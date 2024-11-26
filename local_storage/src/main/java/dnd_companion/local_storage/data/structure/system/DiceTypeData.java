package dnd_companion.local_storage.data.structure.system;

import dnd_companion.local_storage.data.structure.atomic.DiceType;
import dnd_companion.local_storage.data.structure.templates.OptionData;

public record DiceTypeData (DiceType... options)
implements OptionData<DiceType> 
{
	public String collection() {return "system";}
	public String name() {return "dice-types";}
}
