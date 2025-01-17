package dnd_companion.entities.components;

import dnd_companion.entities.models.Component;

public class Weight implements Component
{
	private double value;
	public double value() {return this.value;}
	
	private String unit;
	public String unit() {return this.unit;}
	
	public Weight(double value, String unit_name) {
		this.value = value;
		this.unit = unit_name;
	}
	private Weight(Weight weight) {
		this(weight.value, weight.unit);
	}
	
	@Override public Weight clone() {
		return new Weight(this);
	}
}
