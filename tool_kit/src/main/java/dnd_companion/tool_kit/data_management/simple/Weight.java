package dnd_companion.tool_kit.data_management.simple;

public class Weight 
{
	public WeightUnits unit;
	public double value;
	
	public Weight(WeightUnits unit, double value) {
		this.unit = unit;
		this.value = value;
	}
	
	public enum WeightUnits {
		LBS, KG, G
	}
}