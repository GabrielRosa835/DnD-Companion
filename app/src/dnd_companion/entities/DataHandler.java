package dnd_companion.entities;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.entities.models.Entity;
import dnd_companion.entities.models.EntityCentral;
import dnd_companion.entities.models.EntityScheme;

public class DataHandler 
{
	private ObjectMapper mapper = new ObjectMapper()
			.enable(SerializationFeature.INDENT_OUTPUT);
	
	public void save(EntityCentral central, Entity entity) {
		String path = central.path(entity.name());
		File file = new File(path);
		EntityScheme scheme = central.scheme().loadEntity(entity);
		try {
			mapper.writeValue(file, scheme);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Optional<Entity> retrieve(EntityCentral central, String entity_name) {
		ObjectReader reader = new ObjectMapper().readerFor(central.type());
		String file_path = central.path(entity_name);
		File file = new File(file_path);
		Optional<Entity> retrieved_entity = Optional.empty();
		try {
			retrieved_entity = Optional.of(reader.readValue(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retrieved_entity;
	}
}
