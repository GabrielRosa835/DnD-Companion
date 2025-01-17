package dnd_companion.entities.armor_related.armor;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.models.Entity;
import dnd_companion.entities.models.EntityCentral;

public class ArmorCentral implements EntityCentral
{
	@Override public Class<? extends Entity> type() {
		return ArmorEntity.class;
	}
	@Override public ArmorBuilder builder() {
		return new ArmorBuilder();
	}
	@Override public ArmorFactory factory() {
		return new ArmorFactory();
	}
	@Override public ArmorScheme scheme() {
		return new ArmorScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().armors();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
}
