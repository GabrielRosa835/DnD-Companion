package dnd_companion.entities.models;

import dnd_companion.common.design_patterns.Builder;

public interface EntityBuilder extends Builder
{
	public Entity build();
}
