package dnd_companion.entities.item_related.item_tags;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.DataHandler;

public class ItemTagCentral implements EntityCentral
{
	@Override public Class<? extends Entity> type() {
		return ItemTagEntity.class;
	}
	@Override public ItemTagBuilder builder() {
		return new ItemTagBuilder();
	}
	@Override public ItemTagFactory factory() {
		return new ItemTagFactory();
	}
	@Override public ItemTagScheme scheme() {
		return new ItemTagScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().item_tags();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ItemTagEntity retrieve(String name) {
		return (ItemTagEntity) new DataHandler()
				.retrieve(this, name)
				.get();
	}
}
