package dnd_companion.entities.components;

import dnd_companion.archives.game_helper.actors.entities.system.units.LengthUnitEntity;
import dnd_companion.entities.models.Component;
import dnd_companion.entities.models.types.Measure;

public class Length implements Measure, Component
{
	private double value;
	@Override public double value() {return this.value;}
	
	private LengthUnitEntity unit;
	@Override public LengthUnitEntity unit() {return this.unit;}
	
	public Length(double value, String unit_name) {
		this.value = value;
		this.unit = new LengthUnitEntity(unit_name);
	}
	
	@Override public Length convert_to(String unit_name) {
		LengthUnitEntity new_unit = new LengthUnitEntity(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
}
