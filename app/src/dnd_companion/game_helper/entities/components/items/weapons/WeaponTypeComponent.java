package dnd_companion.game_helper.entities.components.items.weapons;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponTypeData;
import dnd_companion.local_storage.tools.DataKey;

public class WeaponTypeComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	public WeaponTypeComponent(WeaponTypeData data) {
		this.name = data.name();
	}	
	public WeaponTypeComponent() {
		this.name = null;
	}
	public WeaponTypeComponent(String name) {
		this ((WeaponTypeData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_types, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public WeaponTypeComponent copy() {
		WeaponTypeComponent temp = new WeaponTypeComponent();
		temp.name = this.name;
		return temp;
	}
}
