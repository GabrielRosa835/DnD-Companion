package dnd_companion.storage.assembling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.actors.entities.armor.Armor;
import dnd_companion.common.design_patterns.Command;

public class SetupEntitiesCommand implements Command
{
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public void execute() {
		for (Armor.Data data : Armor.Data.values()) {
			Armor entity = data.use();
			try {
				mapper.writeValue(new File(entity.path()), entity);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
