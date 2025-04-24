package app.rpg.snippets.operations;

import app.rpg.elements.compositions.CatalystComposition;
import app.rpg.snippets.models.Catalyst;
import app.rpg.snippets.models.Effect;
import lombok.*;

import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
public class ApplyEffectOperation
		implements Operation<Object>
{
	private Object target;
	private Effect effect;

	@Singular("catalyst")
	private Collection<Catalyst> catalysts;

	public static ApplyEffectOperation with(Object target, Effect effect) {
		var catalysts = CatalystComposition.empty().content();
		return new ApplyEffectOperation(target, effect, catalysts);
	}

	public static ApplyEffectOperation with(Object target, Effect effect, CatalystComposition catalystComposition) {
		var catalysts = catalystComposition.content();
		return new ApplyEffectOperation(target, effect, catalysts);
	}

	public static ApplyEffectOperation with(Object target, Effect effect, Catalyst[] catalystArray) {
		var catalysts = Arrays.asList(catalystArray);
		return new ApplyEffectOperation(target, effect, catalysts);
	}

	public static ApplyEffectOperation with(Object target, Effect effect, Collection<Catalyst> catalysts) {
		return new ApplyEffectOperation(target, effect, catalysts);
	}

	@Override
	public Object process() {
		effect = ApplyAllCatalystsOperation.with(effect, catalysts);
		return effect.applyTo(target);
	}
}
