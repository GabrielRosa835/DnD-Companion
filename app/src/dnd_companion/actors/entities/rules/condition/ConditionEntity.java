package dnd_companion.actors.entities.rules.condition;

import dnd_companion.actors.models.IEntity;
import dnd_companion.effects.IEffect;

public class ConditionEntity implements IEntity
{
	private String name;
	private String description;

	@Override public String name() {return name;}
	public String description() {return description;}

	ConditionEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	protected ConditionEntity(ConditionEntity entity) {
		this(entity.name, entity.description);
	}

	@Override public ConditionEntity clone() {
		return new ConditionEntity(this);
	}
	@Override public String toString() {
		return String.format("Condition[name=%s, description=%s]",
				name, description);
	}
	
	public interface InterEffect extends IEffect {
		public String changeName();
		public String changeDescription();
	}
}
