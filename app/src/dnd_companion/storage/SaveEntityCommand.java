package dnd_companion.storage;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.common.design_patterns.Command;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.entities.addons.models.EntityScheme;

public class SaveEntityCommand implements Command 
{
	private EntityCentral central;
	private Entity entity;
	
	SaveEntityCommand(EntityCentral central, Entity entity) {
		this.central = central;
		this.entity = entity;
	}
	
	public SaveEntityCommand execute() {
		ObjectMapper mapper = new ObjectMapper()
				.enable(SerializationFeature.INDENT_OUTPUT);
		String path = central.path(entity.name());
		File file = new File(path);
		EntityScheme scheme = central.scheme().loadEntity(entity);
		try {
			mapper.writeValue(file, scheme);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
}
