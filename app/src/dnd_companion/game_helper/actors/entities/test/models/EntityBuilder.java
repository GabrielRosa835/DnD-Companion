package dnd_companion.game_helper.actors.entities.test.models;

import dnd_companion.common.design_patterns.Builder;

public interface EntityBuilder extends Builder
{
	public Entity build();
}
