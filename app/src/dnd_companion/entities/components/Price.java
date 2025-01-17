package dnd_companion.entities.components;

import dnd_companion.entities.models.Component;

public class Price implements Component
{
	private double value;
	public double value() {return this.value;}
	
	private String unit;
	public String unit() {return this.unit;}
	
	public Price(double value, String unit_name) {
		this.value = value;
		this.unit = unit_name;
	}
	private Price(Price price) {
		this(price.value, price.unit);
	}
	
	@Override public Price clone() {
		return new Price(this);
	}
}
