package dnd_companion.entities.unit_related.time;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
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
	@Override public Collections collection() {
		return Collections.TIME_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public TimeUnitEntity retrieve(String entity_name) {
		return (TimeUnitEntity) DataHandler.retrieve(this, entity_name);
	}
}
