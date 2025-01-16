package dnd_companion.game_helper.actors.entities.test.condition;

import dnd_companion.game_helper.actors.entities.test.models.EntityBuilder;

public class ConditionBuilder implements EntityBuilder
{
	private String name;
	public ConditionBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	private String description;
	public ConditionBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	@Override public ConditionEntity build() {
		return new ConditionEntity(name, description);
	}
}
