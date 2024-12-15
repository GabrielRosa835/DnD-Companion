package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponCategoryData;

public class WeaponCategoryComponent 
{
	private String name;
	public String name() {return this.name;}
	
	public WeaponCategoryComponent(String name) {
		WeaponCategoryData data = (WeaponCategoryData) new DataHandler()
				.retrieve(new DataKey(new WeaponCategoryData().collection(), name, WeaponCategoryData.class))
				.result();
		this.name = data.name();
	}
}
