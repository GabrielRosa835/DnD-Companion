package dnd_companion.storage.handling;

import java.util.List;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.common.design_patterns.Facade;
import dnd_companion.common.design_patterns.Singleton;

public class DataHandler implements Facade, Singleton
{
	private static DataHandler instance;
	private DataHandler() {}
	public DataHandler use() {
		if (instance != null) {
			return new DataHandler();
		} else {
			return instance;
		}
	}
	
	public static void save(IEntityCentral central, IEntity... entities) {
		new SaveEntitiesCommand(central, entities).execute();
	}
	public static IEntity retrieve(IEntityCentral central, String entity_name) {
		return new RetrieveEntityCommand(central, entity_name).execute().result();
	}
	public static List<IEntity> retrieve(IEntityCentral central) {
		return new RetrieveMultipleCommand(central).execute().result();
	}
}
