package dnd_companion.game_helper.entities.components.items.weapons;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.tools.DataKey;

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
	public WeaponPropertyComponent(WeaponPropertyData data) {
		this (data.name(), data.description());
	}
	public WeaponPropertyComponent(String name) {
		this ((WeaponPropertyData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_properties, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}

	@Override public WeaponPropertyComponent copy() {
		return new WeaponPropertyComponent(
			this.name,
			this.description
		);
	}
}
