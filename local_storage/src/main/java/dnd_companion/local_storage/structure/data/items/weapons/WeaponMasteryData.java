package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.structure.data.templates.OptionData;

public record WeaponMasteryData(String... options) implements OptionData<String>
{
	public WeaponMasteryData() {
		this(
			"Cleave",
			"Graze",
			"Nick",
			"Push",
			"Sap",
			"Slow",
			"Topple",
			"Vex"
		);
	}

	@Override
	public String collection() {return "weapons";}
	@Override
	public String file_name() {return "weapon-masteries";}
}
