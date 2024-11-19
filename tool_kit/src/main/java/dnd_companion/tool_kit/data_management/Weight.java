package dnd_companion.tool_kit.data_management;

public class Weight {
	public Weight.WeightUnits unit;
	public double value;
	
	public enum WeightUnits {
		LBS, KG, G
	}

	public Weight(Weight.WeightUnits unit, double value) {
		super();
		this.unit = unit;
		this.value = value;
	}
	
	
}