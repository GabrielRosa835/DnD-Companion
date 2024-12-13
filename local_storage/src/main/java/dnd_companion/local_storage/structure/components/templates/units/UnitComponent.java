package dnd_companion.local_storage.structure.components.templates.units;

import dnd_companion.local_storage.structure.components.templates.Option;

public interface UnitComponent extends Option<UnitComponent> {
	public String name();
	public String abbreviation();
	public double normalizing_factor();
}
