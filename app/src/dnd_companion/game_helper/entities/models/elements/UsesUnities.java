package dnd_companion.game_helper.entities.models.elements;

import dnd_companion.game_helper.entities.models.components.unit.UnitComponent;

public interface UsesUnities 
{
	public double value();
	public UnitComponent unit();
	public UsesUnities convert_to();
}
