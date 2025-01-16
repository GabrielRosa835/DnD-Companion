package dnd_companion.game_helper.actors.components.measures;

import dnd_companion.game_helper.actors.entities.system.units.TimeUnitEntity;
import dnd_companion.game_helper.actors.models.Measure;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.local_storage.tools.DataKey;

public class TimeStep implements Measure
{
	private double value;
	@Override public double value() {return this.value;}
	
	private TimeUnitEntity unit;
	@Override public TimeUnitEntity unit() {return this.unit;}
	
	public TimeStep(double value, String unit_name) {
		this.value = value;
		this.unit = new TimeUnitEntity(unit_name);
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
