package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponMasteryData;

public class WeaponMasteryComponent 
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	public WeaponMasteryComponent(String name) {
		WeaponMasteryData data = (WeaponMasteryData) new DataHandler().
				retrieve(new DataKey(new WeaponMasteryData().collection(), name, WeaponMasteryData.class))
				.result();
		this.name = data.name();
		this.description = data.description();
	}
}
