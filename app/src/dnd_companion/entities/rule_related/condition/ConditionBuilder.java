package dnd_companion.entities.rule_related.condition;

import dnd_companion.entities.addons.models.EntityBuilder;

public class ConditionBuilder implements EntityBuilder
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
