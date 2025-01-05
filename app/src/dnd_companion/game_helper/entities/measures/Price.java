package dnd_companion.game_helper.entities.measures;

import dnd_companion.game_helper.entities.components.system.units.CurrencyUnitComponent;
import dnd_companion.game_helper.entities.models.Measure;

public class Price implements Measure
{
	private double value;
	@Override public double value() {return this.value;}
	
	private CurrencyUnitComponent unit;
	@Override public CurrencyUnitComponent unit() {return this.unit;}
	
	public Price(double value, String unit_name) {
		this.value = value;
		this.unit = new CurrencyUnitComponent(unit_name);
	}
	
	@Override public Price convert_to(String unit_name) {
		CurrencyUnitComponent new_unit = new CurrencyUnitComponent(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
}
