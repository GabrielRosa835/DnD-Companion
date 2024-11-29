package dnd_companion.local_storage.data_structure.json.items.weapons;

import dnd_companion.local_storage.data_structure.json.templates.OptionData;

public record WeaponTypeData(String... options) implements OptionData<String>
{
	public WeaponTypeData() {
		this(
			"Melee",
			"Ranged"
		);
	}

	@Override
	public String collection() {return "weapons";}
	@Override
	public String file_name() {return "weapon-types";}
}
