package dnd_companion.entities.unit_related.weight;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.DataHandler;

public class WeightUnitCentral implements EntityCentral 
{
	@Override public Class<? extends Entity> type() {
		return WeightUnitEntity.class;
	}
	@Override public WeightUnitBuilder builder() {
		return new WeightUnitBuilder();
	}
	@Override public WeightUnitFactory factory() {
		return new WeightUnitFactory();
	}
	@Override public WeightUnitScheme scheme() {
		return new WeightUnitScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().weight_units();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public WeightUnitEntity retrieve(String entity_name) {
		return (WeightUnitEntity) new DataHandler()
				.retrieve(this, entity_name)
				.get();
	}
}
