package dnd_companion.actors.entities.rules.condition;

import dnd_companion.actors.models.IEntityBuilder;

public class ConditionBuilder implements IEntityBuilder
{
	private String name = "No name";
	private String description = "No description";

	ConditionBuilder() {}

	@Override public ConditionEntity build() {
		return new ConditionEntity(name, description);
	}

	public ConditionBuilder name(String name) {
		this.name = name;
		return this;
	}
	public ConditionBuilder description(String description) {
		this.description = description;
		return this;
	}
}
