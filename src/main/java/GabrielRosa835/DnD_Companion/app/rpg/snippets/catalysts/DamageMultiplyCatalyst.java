package app.rpg.snippets.catalysts;

import app.rpg.elements.components.*;
import app.rpg.snippets.effects.*;
import app.rpg.snippets.models.*;
import lombok.*;

import static co.unruly.control.result.Resolvers.getOrThrow;

@AllArgsConstructor (staticName = "with")
public class DamageMultiplyCatalyst implements Catalyst<HealthComponent>
{
	public final double factor;

	@Override public Effect<HealthComponent> applyTo(Effect<HealthComponent> effect) throws Exception {
		var damageEffect = (DamageEffect) effect;
		int damage = (int) (damageEffect.damage * factor);
		return DamageEffect.with(damage);
	}
}
