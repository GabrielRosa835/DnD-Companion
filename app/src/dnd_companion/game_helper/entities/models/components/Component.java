package dnd_companion.game_helper.entities.models.components;

import dnd_companion.game_helper.entities.data.Data;

public interface Component
{
	public Component copy();
	public Data retrieve(String name);
}
