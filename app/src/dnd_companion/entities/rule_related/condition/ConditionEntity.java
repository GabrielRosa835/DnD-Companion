package dnd_companion.entities.rule_related.condition;

import dnd_companion.entities.addons.models.Entity;

public class ConditionEntity implements Entity 
{
	String name;
	String description;
	
	@Override public String name() {return name;}
	public String description() {return description;}
	
	ConditionEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	private ConditionEntity(ConditionEntity entity) {
		this(entity.name, entity.description);
	}
	
	@Override public ConditionEntity clone() {
		return new ConditionEntity(this);
	}
	@Override public String toString() {
		return String.format("Condition[name=%s, description=%s]",
				name, description);
	}
}
