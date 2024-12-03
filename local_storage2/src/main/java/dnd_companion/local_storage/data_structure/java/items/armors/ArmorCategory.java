package dnd_companion.local_storage.data_structure.java.items.armors;

import dnd_companion.local_storage.data_structure.json.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.data_validation.DataValidator;
import dnd_companion.local_storage.system_components.DataKey;

public class ArmorCategory
{
	private String name;
	public String name() {return this.name;}

	public ArmorCategory (String name) {
		this.name = DataValidator.validate_option(new DataKey(ArmorCategoryData.class), name);
	}
}
