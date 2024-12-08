package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.structure.data.Data;

public interface UnitData extends Data
{
	public String name();
	public String abbreviation();
	public double normalizing_factor();
	
	public static final String file = "units";
}
