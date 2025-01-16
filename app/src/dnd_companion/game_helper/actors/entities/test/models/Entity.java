package dnd_companion.game_helper.actors.entities.test.models;

import dnd_companion.common.design_patterns.Prototype;

public interface Entity extends Prototype
{
	public String name();
	public Entity clone();
}
