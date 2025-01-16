package dnd_companion.game_helper.actors.models;

import dnd_companion.local_storage.structure.models.Data;

public interface Component
{
	public Component buildNull();
	public Component buildByName(String name);
	public Component buildByData(Data data);
	
	public Component copy();
}
