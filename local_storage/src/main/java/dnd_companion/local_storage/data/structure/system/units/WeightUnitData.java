package dnd_companion.local_storage.data.structure.system.units;

import dnd_companion.local_storage.data.structure.atomic.WeightUnit;
import dnd_companion.local_storage.data.structure.templates.OptionData;

public record WeightUnitData (WeightUnit... options)
implements OptionData<WeightUnit> 
{
	public String collection() {return "units";}
	public String name() {return "weight-units";}
}
