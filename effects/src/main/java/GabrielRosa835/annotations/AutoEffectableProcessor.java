package GabrielRosa835.annotations;

import GabrielRosa835.*;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.util.*;
import javax.tools.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

@SupportedAnnotationTypes("GabrielRosa835.annotations.AutoEffectable")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AutoEffectableProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element element : roundEnv.getElementsAnnotatedWith(AutoEffectable.class)) {
			generateEffectInterfaceAndMethod(element);
		}
		return true;
	}

	private void generateEffectInterfaceAndMethod(Element element) {
		String packageName = "GabrielRosa835";
		String className = element.getSimpleName().toString();
		List<? extends VariableElement> fields = ElementFilter.fieldsIn(element.getEnclosedElements());

		String effectMethods = fields.stream()
				.map(field -> {
					String fieldName = field.getSimpleName().toString();
					String fieldType = field.asType().toString();
					String methodName = "change" + ToolBox.capitalize(fieldName);
					return "   %s %s();".formatted(fieldType, methodName);
				})
				.collect(Collectors.joining("\n"));

		String effectInterface = """
					public static interface Effect extends %s.Effect {
					%s
					}
					""".formatted(packageName, effectMethods);

		String applyEffectStatements = fields.stream()
				.map(field -> {
					String fieldName = field.getSimpleName().toString();
					String methodName = "change" + ToolBox.capitalize(fieldName);
					return "   this.%s = effect.%s();".formatted(fieldName, methodName);
				})
				.collect(Collectors.joining("\n"));

		String applyEffectMethod = """
					@Override
					public %s applyEffect(%s.EntityEffect e) {
						 Effect effect = (Effect) e;
						 effect.loadObject(this);
					%s
						 return this;
					}
					""".formatted(className, packageName, applyEffectStatements);

		try {
			String existingClassContent = Files.readString(
					Paths.get(
					processingEnv.getFiler().getResource(
					StandardLocation.SOURCE_OUTPUT, packageName, className + ".java")
					.toUri()));

			String updatedClassContent = existingClassContent.replaceFirst(
					"\\{", "{\n\n" + applyEffectMethod + "\n" + effectInterface + "\n");

			try (Writer writer = processingEnv.getFiler().createSourceFile(
					packageName + "." + className).openWriter()) {
				writer.write(updatedClassContent);
			}
		} catch (IOException e) {
			ExceptionHandler.use().handle(e);
		}
	}
}
