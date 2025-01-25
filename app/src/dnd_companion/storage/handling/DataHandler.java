package dnd_companion.storage.handling;

import java.util.List;

import dnd_companion.common.design_patterns.Facade;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;

public class DataHandler implements Facade
{
	public static void save(EntityCentral central, Entity... entities) {
		new SaveEntitiesCommand(central, entities).execute();
	}
	public static Entity retrieve(EntityCentral central, String entity_name) {
		return new RetrieveEntityCommand(central, entity_name).execute().result();
	}
	public static List<Entity> retrieve(EntityCentral central) {
		return new RetrieveMultipleCommand(central).execute().result();
	}
}
