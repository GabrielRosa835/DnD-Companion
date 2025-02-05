package dnd_companion.storage.handling;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.design_patterns.Command;

public class ValidateDataCommand implements Command
{
	private final EntityCentral central;
	private final Entity entity;

	ValidateDataCommand(EntityCentral central, Entity entity) {
		this.central = central;
		this.entity = entity;
	}

	public boolean execute() {
		Entity retrievedEntity = DataHandler.retrieve(central, entity.name());
		if (retrievedEntity == null) {
			return false;
		} else {
			return true;
		}
	}
}
