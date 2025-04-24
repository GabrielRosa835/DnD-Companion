package app.rpg.snippets.operations;

import app.common.functions.*;
import app.rpg.elements.compositions.CatalystComposition;
import app.rpg.snippets.models.Catalyst;
import app.rpg.snippets.models.Effect;
import co.unruly.control.result.*;
import lombok.*;

import java.util.*;

import static co.unruly.control.result.Introducers.tryTo;
import static co.unruly.control.result.Transformers.attempt;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class ApplyAllCatalystsOperation implements Operation<Effect, Effect>
{
	private Collection<Catalyst> catalysts;

	public static  ApplyAllCatalystsOperation with(CatalystComposition catalystComposition) {
		var catalysts = catalystComposition.content();
		return new ApplyAllCatalystsOperation(catalysts);
	}
	public static  ApplyAllCatalystsOperation with(Catalyst[] catalystArray) {
		var catalysts = Arrays.asList(catalystArray);
		return new ApplyAllCatalystsOperation(catalysts);
	}
	public static  ApplyAllCatalystsOperation with(Collection<Catalyst> catalysts) {
		return new ApplyAllCatalystsOperation(catalysts);
	}

	@Override public Effect process(Effect target) throws Exception {
		var result = Result.success(target, Exception.class);
		for (Catalyst catalyst : catalysts) {
			result.then(attempt(tryTo(catalyst::applyTo)));
		}
		result.either(s -> s, f -> {throw new Exception("");});
	}
}
