package dnd_companion.storage;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.entities.item_related.item_tags.ItemTagCentral;

public class DataInitializer 
{
	private static DataHandler handler = new DataHandler();
	
	private static List<EntityCentral> centrals = Arrays.asList(
			new ItemTagCentral());
	
	public void execute() {
		for (EntityCentral central : centrals) {
			for (Entity entity : central.factory().dataList()) {
				handler.save(central, entity);
			}			
		}
	}
}
