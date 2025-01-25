package dnd_companion.entities.armor_related.armor_category;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class ArmorCategoryCentral implements EntityCentral
{
	@Override public ArmorCategoryBuilder builder() {
		return new ArmorCategoryBuilder();
	}
	@Override public ArmorCategoryFactory factory() {
		return new ArmorCategoryFactory();
	}
	@Override public ArmorCategoryScheme scheme() {
		return new ArmorCategoryScheme();
	}
	@Override public Collections collection() {
		return Collections.ARMOR_CATEGORIES;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ArmorCategoryEntity retrieve(String entity_name) {
		return (ArmorCategoryEntity) DataHandler.retrieve(this, entity_name);
	}
}
