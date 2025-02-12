package dnd_companion.storage.handling;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.common.design_patterns.Command;

public class ValidateDataCommand implements Command
{
	private final IEntityCentral central;
	private final IEntity entity;

	ValidateDataCommand(IEntityCentral central, IEntity entity) {
		this.central = central;
		this.entity = entity;
	}

	public boolean execute() {
		IEntity retrievedEntity = DataHandler.retrieve(central, entity.name());
		if (retrievedEntity == null) {
			return false;
		} else {
			return true;
		}
	}
}
