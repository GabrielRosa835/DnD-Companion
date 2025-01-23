package dnd_companion.storage;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.common.design_patterns.Command;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;

public class RetrieveEntityCommand implements Command 
{
	private EntityCentral central;
	private String entity_name;
	
	private Optional<? extends Entity> result = Optional.empty();
	public Optional<? extends Entity> result() {return result;}
	
	RetrieveEntityCommand(EntityCentral central, String entity_name) {
		this.central = central;
		this.entity_name = entity_name;
	}
	
	public RetrieveEntityCommand execute() {
		ObjectReader reader = new ObjectMapper().readerFor(central.type());
		String path = central.path(entity_name);
		File file = new File(path);
		try {
			result = Optional.of(reader.readValue(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
}
