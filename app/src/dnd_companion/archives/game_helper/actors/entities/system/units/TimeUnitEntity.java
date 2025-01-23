package dnd_companion.archives.game_helper.actors.entities.system.units;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.archives.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.types.Unit;
import dnd_companion.storage.archives.handling.DataHandler;

public class TimeUnitEntity implements Unit 
{
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	private String name;
	public String name() {return this.name;}
	
	private String abbreviation;
	public String abbreviation() {return this.abbreviation;}
	
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
	
	private TimeUnitEntity(String name, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	public TimeUnitEntity() {}
	
	@Override public TimeUnitEntity buildNull() {
		return new TimeUnitEntity(null, null, 0);
	}
	@Override public TimeUnitEntity buildByData(Data d) {
		TimeUnitData data = (TimeUnitData) d;
		return new TimeUnitEntity(data.name(), data.abbreviation(), data.normalizing_factor());
	}
	@Override public TimeUnitEntity buildByName(String name) {
		TimeUnitData data = (TimeUnitData) new DataHandler()
				.retrieve(new DataKey(collections.time_units(), tools.toFileName(name)))
				.result();
		return new TimeUnitEntity().buildByData(data);
	}
	
	@Override public TimeUnitEntity copy() {
		return new TimeUnitEntity(
			this.name,
			this.abbreviation,
			this.normalizing_factor
		);
	}
}
