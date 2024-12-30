package dnd_companion.game_helper.entities.elements.system.units;

import dnd_companion.local_storage.structure.models.components.unit.UnitComponent;
import dnd_companion.local_storage.structure.models.elements.UsesUnities;

public class Length implements UsesUnities
{
	private double value;
	@Override public double value() {return this.value;}
	
	private LengthUnitComponent unit;
	@Override public UnitComponent unit() {return this.unit;}
	
	public Length(double value, String unit_name) {
		this.value = value;
		this.unit = new UnitComponent(unit_name);
	}
	
	@Override
	public Length convert_to(String unit_name) {
		UnitComponent new_unit = new UnitComponent(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
}
