package dnd_companion.local_storage.data.structure.system.units;

import dnd_companion.local_storage.data.structure.atomic.LengthUnit;
import dnd_companion.local_storage.data.structure.templates.OptionData;

public record LengthUnitData (LengthUnit... options)
implements OptionData<LengthUnit> 
{
	public String collection() {return "system";}
	public String name() {return "length-units";}
}
