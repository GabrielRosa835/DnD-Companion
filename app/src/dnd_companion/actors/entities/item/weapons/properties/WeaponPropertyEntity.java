package dnd_companion.actors.entities.item.weapons.properties;

import dnd_companion.actors.models.IComponent;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.storage.archives.handling.DataHandler;

public class WeaponPropertyEntity implements IComponent
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
