package dnd_companion.entities.condition;

import dnd_companion.entities.models.EntityBuilder;

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
