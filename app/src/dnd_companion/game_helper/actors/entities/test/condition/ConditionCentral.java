package dnd_companion.game_helper.actors.entities.test.condition;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.actors.entities.test.models.Entity;
import dnd_companion.game_helper.actors.entities.test.models.EntityCentral;

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
	@Override public ConditionJsonScheme scheme() {
		return new ConditionJsonScheme();
	}
	@Override public CollectionREF collection() {
		return new CollectionsMetadata().units();
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
}
