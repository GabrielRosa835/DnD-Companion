package dnd_companion.game_helper.entities.components.items.weapons;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.data.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.structure.models.components.Component;

public class WeaponPropertyComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	private WeaponPropertyComponent(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public WeaponPropertyComponent() {
		this(null, null);
	}
	public WeaponPropertyComponent(WeaponPropertyData data) {
		this(data.name(), data.description());
	}
	public WeaponPropertyComponent(String name) {
		this(new WeaponPropertyComponent().retrieve(name));
	}
	
	@Override public WeaponPropertyData retrieve(String name) {
		return (WeaponPropertyData) new DataHandler()
				.retrieve(new DataKey(new WeaponPropertyData().collection(), name, WeaponPropertyData.class))
				.result();
	}
	@Override public WeaponPropertyComponent copy() {
		if (this.name == null) {
			return new WeaponPropertyComponent();
		} else {
			return new WeaponPropertyComponent(this.name);
		}
	}
}
