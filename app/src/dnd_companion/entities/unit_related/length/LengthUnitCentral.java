package dnd_companion.entities.unit_related.length;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class LengthUnitCentral implements EntityCentral
{
	@Override public LengthUnitBuilder builder() {
		return new LengthUnitBuilder();
	}
	@Override public LengthUnitFactory factory() {
		return new LengthUnitFactory();
	}
	@Override public LengthUnitScheme scheme() {
		return new LengthUnitScheme();
	}
	@Override public Collections collection() {
		return Collections.LENGTH_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public LengthUnitEntity retrieve(String entity_name) {
		return (LengthUnitEntity) DataHandler.retrieve(this, entity_name);
	}
}
