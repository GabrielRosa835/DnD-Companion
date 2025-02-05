package dnd_companion.actors.entities.item.weapons.category;

import dnd_companion.actors.models.Component;
import dnd_companion.app.local_storage.tools.DataKey;

public class WeaponCategoryEntity implements Component
{
	private String name;
	public String name() {return this.name;}

	public WeaponCategoryEntity() {
		this.name = null;
	}
	public WeaponCategoryEntity(WeaponCategoryData data) {
		this.name = data.name();
	}
	public WeaponCategoryEntity(String name) {
		this(new WeaponCategoryEntity().retrieve(name));
	}

	@Override public WeaponCategoryData retrieve(String name) {
		return (WeaponCategoryData) new DataHandler()
				.retrieve(new DataKey(new WeaponCategoryData().collection(), name, WeaponCategoryData.class))
				.result();
	}
	@Override public WeaponCategoryEntity copy() {
		if (this.name == null) {
			return new WeaponCategoryEntity();
		} else {
			return new WeaponCategoryEntity(this.name);
		}
	}
}
