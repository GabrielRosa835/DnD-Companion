package dnd_companion.game_helper.actors.components.measures;

import dnd_companion.game_helper.actors.entities.system.units.CurrencyUnitEntity;
import dnd_companion.game_helper.actors.models.Measure;

public class Price implements Measure
{
	private double value;
	@Override public double value() {return this.value;}
	
	private CurrencyUnitEntity unit;
	@Override public CurrencyUnitEntity unit() {return this.unit;}
	
	public Price(double value, String unit_name) {
		this.value = value;
		this.unit = new CurrencyUnitEntity(unit_name);
	}
	
	@Override public Price convert_to(String unit_name) {
		CurrencyUnitEntity new_unit = new CurrencyUnitEntity(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
}
