package dnd_companion.game_helper.entities.measures;

import dnd_companion.game_helper.entities.components.system.units.LengthUnitComponent;
import dnd_companion.game_helper.entities.models.Measure;

public class Length implements Measure
{
	private double value;
	@Override public double value() {return this.value;}
	
	private LengthUnitComponent unit;
	@Override public LengthUnitComponent unit() {return this.unit;}
	
	public Length(double value, String unit_name) {
		this.value = value;
		this.unit = new LengthUnitComponent(unit_name);
	}
	
	@Override public Length convert_to(String unit_name) {
		LengthUnitComponent new_unit = new LengthUnitComponent(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
}
