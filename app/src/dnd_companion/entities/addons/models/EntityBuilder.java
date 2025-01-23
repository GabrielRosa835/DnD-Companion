package dnd_companion.entities.addons.models;

import dnd_companion.common.design_patterns.Builder;

public interface EntityBuilder extends Builder
{
	public Entity build();
}
