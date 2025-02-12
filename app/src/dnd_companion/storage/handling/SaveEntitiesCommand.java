package dnd_companion.storage.handling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.actors.models.IEntityScheme;
import dnd_companion.common.ToolBox;
import dnd_companion.common.design_patterns.Command;

public class SaveEntitiesCommand implements Command
{
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	private IEntityCentral central;
	private IEntity[] entities;

	public SaveEntitiesCommand(IEntityCentral central, IEntity[] entities) {
		this.central = central;
		this.entities = entities;
	}

	public boolean execute() {
		for (IEntity entity : entities) {
			String path = central.path(entity.name());
			File file = new File(path);
			IEntityScheme scheme = central.scheme().loadEntity(entity);
			try {
				mapper.writeValue(file, scheme);
			} catch (IOException e) {
				ToolBox.exceptionHandler(e);
				return false;
			}
		}
		return true;
	}
}
