package dnd_companion.entities.models.types;

public interface Measure 
{
	public double value();
	public Unit unit();
	public Measure convert_to(String new_unit);
}
