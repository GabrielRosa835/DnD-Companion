package dnd_companion.local_storage.data.structure.system;

import dnd_companion.local_storage.data.structure.templates.OptionData;

public record DamageTypeData (String... options)
implements OptionData<String> 
{
	public String collection() {return "system";}
	public String name() {return "damage-types";}
}
