package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.game_helper.entities.data.system.units.WeightUnitData;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.components.unit.UnitComponent;

public class WeightUnitComponent implements UnitComponent 
{
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private WeightUnitComponent(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	private WeightUnitComponent(WeightUnitData data) {
		this(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	public WeightUnitComponent() {
		this(null, null, 0);
	}
	public WeightUnitComponent(String name) {
		this(new WeightUnitComponent().retrieve(name));
	}
	
	@Override public WeightUnitData retrieve(String name) {
		return (WeightUnitData) new DataHandler()
				.retrieve(new DataKey(new WeightUnitData().collection(), name, WeightUnitData.class))
				.result();
	}
	@Override public WeightUnitComponent copy() {
		return new WeightUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
