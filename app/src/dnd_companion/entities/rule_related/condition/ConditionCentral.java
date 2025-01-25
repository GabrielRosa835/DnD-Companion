package dnd_companion.entities.rule_related.condition;

import java.io.File;

import dnd_companion.common.metadata.Collections;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.handling.DataHandler;

public class ConditionCentral implements EntityCentral
{
	@Override public ConditionBuilder builder() {
		return new ConditionBuilder();
	}
	@Override public ConditionFactory factory() {
		return new ConditionFactory();
	}
	@Override public ConditionScheme scheme() {
		return new ConditionScheme();
	}
	@Override public Collections collection() {
		return Collections.CONDITIONS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ConditionEntity retrieve(String entity_name) {
		return (ConditionEntity) DataHandler.retrieve(this, entity_name);
	}
}
