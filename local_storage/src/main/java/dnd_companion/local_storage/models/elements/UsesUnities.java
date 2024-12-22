package dnd_companion.local_storage.models.elements;

import dnd_companion.local_storage.models.components.unit.UnitComponent;

public interface UsesUnities 
{
	public double value();
	public UnitComponent unit();
	public UsesUnities convert_to();
}
