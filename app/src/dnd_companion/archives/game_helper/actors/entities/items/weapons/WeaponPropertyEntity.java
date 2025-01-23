package dnd_companion.archives.game_helper.actors.entities.items.weapons;

import dnd_companion.archives.game_helper.actors.models.Component;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.weapon_related.WeaponPropertyData;
import dnd_companion.storage.archives.handling.DataHandler;

public class WeaponPropertyEntity implements Component
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	private WeaponPropertyEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public WeaponPropertyEntity(WeaponPropertyData data) {
		this (data.name(), data.description());
	}
	public WeaponPropertyEntity(String name) {
		this ((WeaponPropertyData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_properties, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}

	@Override public WeaponPropertyEntity copy() {
		return new WeaponPropertyEntity(
			this.name,
			this.description
		);
	}
}
