package dnd_companion.actors.entities.item.weapons.type;

import dnd_companion.actors.models.IComponent;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.storage.archives.handling.DataHandler;

public class WeaponTypeEntity implements IComponent
{
	private String name;
	public String name() {return this.name;}

	public WeaponTypeEntity(WeaponTypeData data) {
		this.name = data.name();
	}
	public WeaponTypeEntity() {
		this.name = null;
	}
	public WeaponTypeEntity(String name) {
		this ((WeaponTypeData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().weapon_types,
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}

	@Override public WeaponTypeEntity copy() {
		WeaponTypeEntity temp = new WeaponTypeEntity();
		temp.name = this.name;
		return temp;
	}
}
