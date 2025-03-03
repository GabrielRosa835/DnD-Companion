package GabrielRosa835.annotations;

/*


<build>
    <plugins>

    </plugins>
</build>

Implement the Annotation Processor:
Ensure your annotation processor is correctly implemented and registered.
Create a file named META-INF/services/javax.annotation.processing.
Processor and include the fully qualified name of your processor class:
com.example.AutoCloneProcessor
 */

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Types;
import java.util.Set;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("com.example.AutoClone")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AutoCloneProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element element : roundEnv.getElementsAnnotatedWith(AutoClone.class)) {
			generateCloneMethod(element);
		}
		return true;
	}

	private void generateCloneMethod(Element element) {
		Name().toString();
		List<? extends VariableElement> fields = ElementFilter.fieldsIn(element.getEnclosedElements());

		// Create parameters for the all-args constructor
		List<ParameterSpec> parameters = fields.stream()
				.map(field -> ParameterSpec.builder(field.asType(), field.getSimpleName().toString()).build())
				.collect(Collectors.toList());

		// Create the clone method
		MethodSpec.Builder cloneMethodBuilder = MethodSpec.methodBuilder("clone")
				.addModifiers(Modifier.PUBLIC)
				.returns(TypeName.get(element.asType()))
				.addAnnotation(Override.class);

		String constructorArgs = parameters.stream()
				.map(ParameterSpec::name)
				.collect(Collectors.joining(", "));
		cloneMethodBuilder.addStatement("$T clone = new $T($L)", element.asType(), element.asType(), constructorArgs);

		Types typeUtils = processingEnv.getTypeUtils();
		TypeElement cloneableType = processingEnv.getElementUtils().getTypeElement("java.lang.Cloneable");

		for (VariableElement field : fields) {
			String fieldName = field.getSimpleName().toString();
			TypeName fieldType = TypeName.get(field.asType());
			boolean isPrimitiveOrString = field.asType().getKind().isPrimitive() || field.asType().toString().equals("java.lang.String");
			boolean isCloneable = typeUtils.isAssignable(field.asType(), cloneableType.asType());

			if (isPrimitiveOrString) {
				cloneMethodBuilder.addStatement("clone.$L = this.$L", fieldName, fieldName);
			} else if (isCloneable) {
				cloneMethodBuilder.addStatement("clone.$L = ($T) this.$L.clone()", fieldName, fieldType, fieldName);
			} else {
				cloneMethodBuilder.addStatement("clone.$L = this.$L", fieldName, fieldName);
			}
		}

		cloneMethodBuilder.addStatement("return clone");

		MethodSpec cloneMethod = cloneMethodBuilder.build();

		TypeSpec classSpec = TypeSpec.classBuilder(className)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(cloneMethod)
				.build();

		JavaFile javaFile = JavaFile.builder("com.example", classSpec)
				.build();

		try {
			javaFile.writeTo(processingEnv.getFiler());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
