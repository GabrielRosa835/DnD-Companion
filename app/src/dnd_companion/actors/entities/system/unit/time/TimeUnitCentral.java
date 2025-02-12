package dnd_companion.actors.entities.system.unit.time;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.system.unit.time.data.Days;
import dnd_companion.actors.entities.system.unit.time.data.Hours;
import dnd_companion.actors.entities.system.unit.time.data.Minutes;
import dnd_companion.actors.entities.system.unit.time.data.NormalTimeUnit;
import dnd_companion.actors.entities.system.unit.time.data.Seconds;
import dnd_companion.actors.entities.system.unit.time.data.Weeks;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class TimeUnitCentral implements IEntityCentral
{
	private static TimeUnitCentral instance;
	private TimeUnitCentral() {}
	public static TimeUnitCentral use() {
		return instance == null? new TimeUnitCentral() : instance;
	}
	
	@Override public TimeUnitBuilder builder() {
		return new TimeUnitBuilder();
	}
	@Override public TimeUnitScheme scheme() {
		return new TimeUnitScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.TIME_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public TimeUnitEntity retrieve(String entity_name) {
		return (TimeUnitEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public TimeUnitEntity[] data() {
		return Arrays.asList(
				new Days(),
				new Hours(),
				new Minutes(),
				new NormalTimeUnit(),
				new Seconds(),
				new Weeks())
				.toArray(TimeUnitEntity[]::new);
	}
}
