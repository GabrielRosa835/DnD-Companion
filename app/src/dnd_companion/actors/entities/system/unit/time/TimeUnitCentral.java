package dnd_companion.actors.entities.system.unit.time;

import java.io.File;

import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class TimeUnitCentral implements EntityCentral
{
	@Override public TimeUnitBuilder builder() {
		return new TimeUnitBuilder();
	}
	@Override public TimeUnitFactory factory() {
		return new TimeUnitFactory();
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
}
