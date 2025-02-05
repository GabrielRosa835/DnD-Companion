package dnd_companion.storage.handling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.actors.models.EntityScheme;
import dnd_companion.common.design_patterns.Command;

public class RetrieveEntityCommand implements Command
{
	private EntityCentral central;
	private String entity_name;

	private Entity result;
	public Entity result() {return result;}

	RetrieveEntityCommand(EntityCentral central, String entity_name) {
		this.central = central;
		this.entity_name = entity_name;
	}

	public RetrieveEntityCommand execute() {
		ObjectReader reader = new ObjectMapper().readerFor(central.scheme().getClass());
		String path = central.path(entity_name);
		File file = new File(path);
		try {
			EntityScheme scheme = reader.readValue(file);
			result = scheme.retrieveEntity();
		} catch (IOException e) {
			e.printStackTrace();
			result = null;
		}
		return this;
	}
}
