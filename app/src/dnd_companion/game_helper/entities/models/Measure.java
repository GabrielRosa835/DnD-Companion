package dnd_companion.game_helper.entities.models;

public interface Measure 
{
	public double value();
	public UnitComponent unit();
	public Measure convert_to(String new_unit);
}
