package dnd_companion.local_storage.structure.data.items.armors;

import dnd_companion.local_storage.structure.data.templates.OptionData;

public record ArmorCategoryData (String... options)
implements OptionData<String>
{
	public ArmorCategoryData() {
		this(
			"None",
			"Shield",
			"Light",
			"Medium",
			"Heavy"
		);
	}

	@Override
	public String collection() {return "armors";}
	@Override
	public String file_name() {return "armor-categories";}
}
