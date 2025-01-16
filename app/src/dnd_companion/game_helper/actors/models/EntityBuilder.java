package dnd_companion.game_helper.actors.models;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.handling.DataHandler;

public interface EntityBuilder 
{
	final CollectionsMetadata collections = new CollectionsMetadata();
	final DataHandler handler = new DataHandler();
	final ToolBox tools = new ToolBox(); 
	
	public Entity buildNull();
	public Entity buildByName(String name);
	public Entity deepCopy(Entity e);
}
