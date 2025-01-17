package dnd_companion.entities.condition;

import dnd_companion.entities.models.Entity;

public class ConditionEntity implements Entity 
{
	String name;
	@Override public String name() {return name;}
	
	String description;
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
}
