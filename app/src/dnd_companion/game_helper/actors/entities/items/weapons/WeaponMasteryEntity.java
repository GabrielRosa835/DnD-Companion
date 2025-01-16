package dnd_companion.game_helper.actors.entities.items.weapons;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.actors.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.tools.DataKey;

public class WeaponMasteryEntity implements Component
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
