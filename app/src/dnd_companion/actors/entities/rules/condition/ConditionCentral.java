package dnd_companion.actors.entities.rules.condition;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.rules.condition.data.Blinded;
import dnd_companion.actors.entities.rules.condition.data.Poisoned;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class ConditionCentral implements EntityCentral
{
	private static ConditionCentral instance;
	private ConditionCentral() {}
	public static ConditionCentral use() {
		return instance != null? new ConditionCentral() : instance;
	}
	
	@Override public ConditionBuilder builder() {
		return new ConditionBuilder();
	}
	@Override public ConditionScheme scheme() {
		return new ConditionScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.CONDITIONS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ConditionEntity retrieve(String entity_name) {
		return (ConditionEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public ConditionEntity[] data() {
		return Arrays.asList(
				new Blinded(),
				new Poisoned())
				.toArray(ConditionEntity[]::new);
	}
}
