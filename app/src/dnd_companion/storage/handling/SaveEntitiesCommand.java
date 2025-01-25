package dnd_companion.storage.handling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.common.design_patterns.Command;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.entities.addons.models.EntityScheme;

public class SaveEntitiesCommand implements Command
{
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	private EntityCentral central;
	private Entity[] entities;

	public SaveEntitiesCommand(EntityCentral central, Entity[] entities) {
		this.central = central;
		this.entities = entities;
	}

	public void execute() {
		for (Entity entity : entities) {
			String path = central.path(entity.name());
			File file = new File(path);
			EntityScheme scheme = central.scheme().loadEntity(entity);
			try {
				mapper.writeValue(file, scheme);
			} catch (IOException e) {
				ToolBox.exceptionHandler(e);
			}
		}
	}
}
