package dnd_companion.tool_kit.data_management;

public class Price {
	public Price.PriceUnits unit;
	public double value;
	
	public enum PriceUnits {
		PP, GP, EP, SP, CP
	}

	public Price(Price.PriceUnits unit, double value) {
		super();
		this.unit = unit;
		this.value = value;
	}
	
	
}