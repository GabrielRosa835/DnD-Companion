package dnd_companion.local_storage.structure.components.items.armors;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.validation.DataValidator;

public class ArmorCategory
{
	private String name;
	public String name() {return this.name;}

	public ArmorCategory (String name) {
		this.name = DataValidator.validate_option(new DataKey(ArmorCategoryData.class), name);
	}
}
