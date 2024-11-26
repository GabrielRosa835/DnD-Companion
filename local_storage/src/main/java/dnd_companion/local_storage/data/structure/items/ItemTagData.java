package dnd_companion.local_storage.data.structure.items;

import dnd_companion.local_storage.data.structure.templates.OptionData;

public record ItemTagData (String... options)
implements OptionData<String> 
{
	public String collection() {return "items";}
	public String name() {return "item-tags";}
}
