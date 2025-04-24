package app.rpg.snippets.models;

import app.common.functions.*;

@FunctionalInterface
public interface Catalyst extends
		Operation<Effect, Effect>
{
	Effect applyTo(Effect effect) throws Exception;

	@Override default Effect process(Effect effect) throws Exception {
		return applyTo(effect);
	}
}
