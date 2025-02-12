package dnd_companion.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.actors.entities.armor.ArmorCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.storage.assembling.StorageAssembler;

public class Main
{
	public static void main(String[] args) {
		StorageAssembler.clearData();
		StorageAssembler.setup();
		
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

		List<IEntityCentral> centralList = new ArrayList<>();
		centralList.add(ItemTagCentral.use());
		centralList.add(ArmorCategoryCentral.use());
		centralList.add(ArmorCentral.use());
		
		for (IEntityCentral central : centralList) {			
			for (IEntity entity : central.data()) {
				String path = central.path(entity.name());
				File file = new File(path);
				try {
					mapper.writeValue(file, entity);
				} catch (IOException e) {
					ToolBox.exceptionHandler(e);
				}
			}
		}
	}
}
