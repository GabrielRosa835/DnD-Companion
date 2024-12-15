package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponTypeData;

public class WeaponTypeComponent 
{
	private String name;
	public String name() {return this.name;}
	
	public WeaponTypeComponent(String name) {
		WeaponTypeData data = (WeaponTypeData) new DataHandler()
				.retrieve(new DataKey(new WeaponTypeData().collection(), name, WeaponTypeData.class))
				.result();
		this.name = data.name();
	}
}
