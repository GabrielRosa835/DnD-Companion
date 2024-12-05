package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.structure.data.templates.OptionData;

public record WeaponCategoryData(String... options) implements OptionData<String>
{
	public WeaponCategoryData() {
		this(
			"Simple",
			"Martial"
		);
	}

	@Override
	public String collection() {return "weapons";}
	@Override
	public String file_name() {return "weapon-categories";}
}
