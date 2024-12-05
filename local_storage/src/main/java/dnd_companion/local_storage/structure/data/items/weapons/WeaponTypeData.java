package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.structure.data.templates.OptionData;

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
