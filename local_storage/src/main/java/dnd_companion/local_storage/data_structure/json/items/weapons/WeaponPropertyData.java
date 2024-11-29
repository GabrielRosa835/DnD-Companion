package dnd_companion.local_storage.data_structure.json.items.weapons;

import dnd_companion.local_storage.data_structure.json.templates.OptionData;

public record WeaponPropertyData(String... options) implements OptionData<String>
{
	public WeaponPropertyData() {
		this(
			"Ammunition",
			"Finesse",
			"Heavy",
			"Light",
			"Loading",
			"Range",
			"Reach",
			"Thrown",
			"Two-Handed",
			"Versatile"
		);
	}

	@Override
	public String collection() {return "weapons";}
	@Override
	public String file_name() {return "weapon-properties";}
}
