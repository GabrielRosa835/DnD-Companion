package app.rpg.snippets.models;

import app.common.functions.*;

@FunctionalInterface
public interface Effect extends
		Operation<Object, Object>
{
	Object applyTo(Object target);

	@Override default Object process(Object target) {
		return applyTo(target);
	}
}