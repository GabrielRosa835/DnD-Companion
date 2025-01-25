package dnd_companion.entities.armor_related.armor;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class ArmorCentral implements EntityCentral
{
	@Override public ArmorBuilder builder() {
		return new ArmorBuilder();
	}
	@Override public ArmorFactory factory() {
		return new ArmorFactory();
	}
	@Override public ArmorScheme scheme() {
		return new ArmorScheme();
	}
	@Override public Collections collection() {
		return Collections.ARMORS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ArmorEntity retrieve(String entity_name) {
		return (ArmorEntity) DataHandler.retrieve(this, entity_name);
	}
}
