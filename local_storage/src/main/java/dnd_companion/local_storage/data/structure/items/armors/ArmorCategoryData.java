package dnd_companion.local_storage.data.structure.items.armors;

import dnd_companion.local_storage.data.structure.templates.OptionData;

public record ArmorCategoryData (String... options)
implements OptionData<String> 
{
	public String collection() {return "armors";}
	public String name() {return "armor-categories";}
}
