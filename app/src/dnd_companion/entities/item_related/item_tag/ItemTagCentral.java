package dnd_companion.entities.item_related.item_tag;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class ItemTagCentral implements EntityCentral
{
	@Override public ItemTagBuilder builder() {
		return new ItemTagBuilder();
	}
	@Override public ItemTagFactory factory() {
		return new ItemTagFactory();
	}
	@Override public ItemTagScheme scheme() {
		return new ItemTagScheme();
	}
	@Override public Collections collection() {
		return Collections.ITEM_TAGS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ItemTagEntity retrieve(String name) {
		return (ItemTagEntity) DataHandler.retrieve(this, name);
	}
}
