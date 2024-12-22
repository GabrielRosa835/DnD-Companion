package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.models.components.Component;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponTypeData;

public class WeaponTypeComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	public WeaponTypeComponent() {
		this.name = null;
	}
	public WeaponTypeComponent(WeaponTypeData data) {
		this.name = data.name();
	}	
	public WeaponTypeComponent(String name) {
		this(new WeaponTypeComponent().retrieve(name));
	}
	
	@Override public WeaponTypeData retrieve(String name) {
		return (WeaponTypeData) new DataHandler()
				.retrieve(new DataKey(new WeaponTypeData().collection(), name, WeaponTypeData.class))
				.result();
	}
	@Override public WeaponTypeComponent copy() {
		if (this.name == null) {
			return new WeaponTypeComponent();
		} else {
			return new WeaponTypeComponent(this.name);
		}
	}
}
