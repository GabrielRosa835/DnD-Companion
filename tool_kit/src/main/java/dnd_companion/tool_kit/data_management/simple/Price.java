package dnd_companion.tool_kit.data_management.simple;

public class Price
{
	public PriceUnits unit;
	public double value;
	
	public Price(PriceUnits unit, double value) {
		this.unit = unit;
		this.value = value;
	}
	
	public enum PriceUnits {
		PP, GP, EP, SP, CP
	}
}