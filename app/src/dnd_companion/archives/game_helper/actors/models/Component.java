package dnd_companion.archives.game_helper.actors.models;

import dnd_companion.archives.local_storage.structure.models.Data;

public interface Component
{
	public Component buildNull();
	public Component buildByName(String name);
	public Component buildByData(Data data);
	
	public Component copy();
}
