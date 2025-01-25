package dnd_companion.archives.game_helper.actors.entities.items.weapons;

import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.weapon_related.WeaponTypeData;
import dnd_companion.storage.archives.handling.DataHandler;

public class WeaponTypeEntity implements Component
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
