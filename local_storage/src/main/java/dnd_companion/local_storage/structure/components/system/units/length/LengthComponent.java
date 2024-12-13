package dnd_companion.local_storage.structure.components.system.units.length;

import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.templates.Component;
import dnd_companion.local_storage.structure.components.templates.units.UnitGroup;

public class LengthComponent implements Component, UnitGroup<LengthComponent, LengthUnitComponent>
{
	private double value;
	@Override public double value() {return this.value;}
	
	private LengthUnitComponent unit;
	@Override public LengthUnitComponent unit() {return this.unit;}
	
	public LengthComponent(double value, LengthUnitComponent unit) {
		this.value = value;
		this.unit = unit;
	}
	public LengthComponent(double value, String unit_value) {
		this.value = value;
		LengthUnitData unit_data = new DataHandler().
		this.unit = new Data
	}
	
	@Override
	public LengthComponent convert_to(String unit_name) {
		// TODO Auto-generated method stub
		return null;
	}
}
