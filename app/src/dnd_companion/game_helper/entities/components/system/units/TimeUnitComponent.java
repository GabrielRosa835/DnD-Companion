package dnd_companion.game_helper.entities.components.system.units;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.UnitComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.local_storage.tools.DataKey;

public class TimeUnitComponent implements UnitComponent 
{
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private TimeUnitComponent(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	public TimeUnitComponent() {}
	
	@Override public TimeUnitComponent buildNull() {
		return new TimeUnitComponent(null, null, 0);
	}
	@Override public TimeUnitComponent buildByData(Data d) {
		TimeUnitData data = (TimeUnitData) d;
		return new TimeUnitComponent(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	@Override public TimeUnitComponent buildByName(String name) {
		TimeUnitData data = (TimeUnitData) new DataHandler()
				.retrieve(new DataKey(collections.time_units(), tools.toFileName(name)))
				.result();
		return new TimeUnitComponent().buildByData(data);
	}
	
	@Override public TimeUnitComponent copy() {
		return new TimeUnitComponent(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
