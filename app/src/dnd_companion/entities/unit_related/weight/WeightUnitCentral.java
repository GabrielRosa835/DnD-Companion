package dnd_companion.entities.unit_related.weight;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class WeightUnitCentral implements EntityCentral
{
	@Override public WeightUnitBuilder builder() {
		return new WeightUnitBuilder();
	}
	@Override public WeightUnitFactory factory() {
		return new WeightUnitFactory();
	}
	@Override public WeightUnitScheme scheme() {
		return new WeightUnitScheme();
	}
	@Override public Collections collection() {
		return Collections.WEIGHT_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public WeightUnitEntity retrieve(String entity_name) {
		return (WeightUnitEntity) DataHandler.retrieve(this, entity_name);
	}
}
