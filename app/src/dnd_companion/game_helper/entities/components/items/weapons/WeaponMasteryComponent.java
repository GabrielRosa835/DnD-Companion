package dnd_companion.game_helper.entities.components.items.weapons;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.tools.DataKey;

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
	public WeaponMasteryComponent(WeaponMasteryData data) {
		this(data.name(), data.description());
	}
	public WeaponMasteryComponent(String name) {
		this((WeaponMasteryData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_masteries, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	@Override public WeaponMasteryComponent copy() {
		return new WeaponMasteryComponent(
			this.name,
			this.description
		);
				
	}
}
