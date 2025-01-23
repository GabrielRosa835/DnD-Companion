package dnd_companion.entities.armor_related.armor_category;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.DataHandler;

public class ArmorCategoryCentral implements EntityCentral
{
	@Override public Class<? extends Entity> type() {
		return ArmorCategoryEntity.class;
	}
	@Override public ArmorCategoryBuilder builder() {
		return new ArmorCategoryBuilder();
	}
	@Override public ArmorCategoryFactory factory() {
		return new ArmorCategoryFactory();
	}
	@Override public ArmorCategoryScheme scheme() {
		return new ArmorCategoryScheme();
	}
	@Override
	public CollectionREF collection() {
		return new CollectionsMetadata().armor_categories();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ArmorCategoryEntity retrieve(String entity_name) {
		return (ArmorCategoryEntity) new DataHandler()
				.retrieve(this, entity_name)
				.get();
	}
}
