package dnd_companion.entities.rule_related.condition;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.storage.DataHandler;

public class ConditionCentral implements EntityCentral 
{
	@Override public Class<? extends Entity> type() {
		return ConditionEntity.class;
	}
	@Override public ConditionBuilder builder() {
		return new ConditionBuilder();
	}
	@Override public ConditionFactory factory() {
		return new ConditionFactory();
	}
	@Override public ConditionScheme scheme() {
		return new ConditionScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().units();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ConditionEntity retrieve(String entity_name) {
		return (ConditionEntity) new DataHandler()
				.retrieve(this, entity_name)
				.get();
	}
}
