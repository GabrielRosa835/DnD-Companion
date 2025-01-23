package dnd_companion.storage;

import java.util.Optional;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;

public class DataHandler 
{
	public void save(EntityCentral central, Entity entity) {
		new SaveEntityCommand(central, entity).execute();
	}
	public Optional<? extends Entity> retrieve(EntityCentral central, String entity_name) {
		return new RetrieveEntityCommand(central, entity_name).execute().result();
	}
}
