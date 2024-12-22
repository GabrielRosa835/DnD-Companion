package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.models.components.Component;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponCategoryData;

public class WeaponCategoryComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	public WeaponCategoryComponent() {
		this.name = null;
	}
	public WeaponCategoryComponent(WeaponCategoryData data) {
		this.name = data.name();
	}
	public WeaponCategoryComponent(String name) {
		this(new WeaponCategoryComponent().retrieve(name));
	}
	
	@Override public WeaponCategoryData retrieve(String name) {
		return (WeaponCategoryData) new DataHandler()
				.retrieve(new DataKey(new WeaponCategoryData().collection(), name, WeaponCategoryData.class))
				.result();
	}
	@Override public WeaponCategoryComponent copy() {
		if (this.name == null) {
			return new WeaponCategoryComponent();
		} else {
			return new WeaponCategoryComponent(this.name);
		}
	}
}
