package dnd_companion.game_helper.entities.components.items.weapons;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.data.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.structure.models.components.Component;

public class WeaponMasteryComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	private WeaponMasteryComponent(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public WeaponMasteryComponent() {
		this(null, null);
	}
	public WeaponMasteryComponent(WeaponMasteryData data) {
		this(data.name(), data.description());
	}
	public WeaponMasteryComponent(String name) {
		this(new WeaponMasteryComponent().retrieve(name));
	}
	
	@Override public WeaponMasteryData retrieve(String name) {
		return (WeaponMasteryData) new DataHandler()
				.retrieve(new DataKey(new WeaponMasteryData().collection(), name, WeaponMasteryData.class))
				.result();
	}
	@Override public WeaponMasteryComponent copy() {
		if (this.name == null) {
			return new WeaponMasteryComponent();
		} else {
			return new WeaponMasteryComponent(this.name);
		}
	}
}
