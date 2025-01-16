package dnd_companion.game_helper.actors.entities.items.weapons;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.actors.data.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.structure.models.components.Component;

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
