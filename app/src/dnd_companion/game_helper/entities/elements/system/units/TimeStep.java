package dnd_companion.game_helper.entities.elements.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.UnitGroupComponent;
import dnd_companion.local_storage.structure.data.system.units.TimeUnitData;

public class TimeStep implements UnitGroupComponent
{
	private double value;
	@Override public double value() {return this.value;}
	
	private Unit unit;
	@Override public Unit unit() {return this.unit;}
	
	public TimeStep(double value, String unit_name) {
		this.value = value;
		this.unit = new Unit(unit_name);
	}
	
	@Override
	public TimeStep convert_to(String unit_name) {
		Unit new_unit = new Unit(unit_name);
		this.value = this.value * (new_unit.normalizing_factor() / this.unit.normalizing_factor());
		return this;
	}
	
	public class Unit implements UnitOption
	{		
		private String name;
		@Override public String name() {return this.name;}

		private String abbreviation; 
		@Override public String abbreviation() {return this.abbreviation;}

		private double normalizing_factor;
		@Override public double normalizing_factor() {return this.normalizing_factor;}

		public Unit(String name) {
			Unit data = (Unit) new DataHandler()
					.retrieve(new DataKey(new TimeUnitData().collection(), name, TimeUnitData.class))
					.result();
			this.name = data.name();
			this.abbreviation = data.abbreviation();
			this.normalizing_factor = data.normalizing_factor();
		}
	}
}
