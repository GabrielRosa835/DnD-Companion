package dnd_companion.storage.handling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.actors.models.IEntityScheme;
import dnd_companion.common.design_patterns.Command;

public class RetrieveEntityCommand implements Command
{
	private IEntityCentral central;
	private String entity_name;

	private IEntity result;
	public IEntity result() {return result;}

	RetrieveEntityCommand(IEntityCentral central, String entity_name) {
		this.central = central;
		this.entity_name = entity_name;
	}

	public RetrieveEntityCommand execute() {
		ObjectReader reader = new ObjectMapper().readerFor(central.scheme().getClass());
		String path = central.path(entity_name);
		File file = new File(path);
		try {
			IEntityScheme scheme = reader.readValue(file);
			result = scheme.retrieveEntity();
		} catch (IOException e) {
			e.printStackTrace();
			result = null;
		}
		return this;
	}
}
