package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponPropertyData;

public class WeaponPropertyComponent 
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	public WeaponPropertyComponent(String name) {
		WeaponPropertyData data = (WeaponPropertyData) new DataHandler().
				retrieve(new DataKey(new WeaponPropertyData().collection(), name, WeaponPropertyData.class))
				.result();
		this.name = data.name();
		this.description = data.description();
	}
}
