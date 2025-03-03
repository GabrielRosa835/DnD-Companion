package dnd_companion.actors.entities.item.weapons.mastery;

import dnd_companion.actors.models.IComponent;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.storage.archives.handling.DataHandler;

public class WeaponMasteryEntity implements IComponent
{
	private String name;
	public String name() {return this.name;}

	private String description;
	public String description() {return this.description;}

	private WeaponMasteryEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public WeaponMasteryEntity(WeaponMasteryData data) {
		this(data.name(), data.description());
	}
	public WeaponMasteryEntity(String name) {
		this((WeaponMasteryData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_masteries,
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	@Override public WeaponMasteryEntity copy() {
		return new WeaponMasteryEntity(
			this.name,
			this.description
		);

	}
}
