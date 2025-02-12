package dnd_companion.actors.entities.armor.category;

import dnd_companion.actors.components.measure.Period;
import dnd_companion.actors.models.IEntity;
import dnd_companion.effects.IEffect;

public class ArmorCategoryEntity implements IEntity
{
	private String name;
	private String description;

	@Override public String name() {return name;}
	public String description() {return description;}
	
	// =======================================
	private Period don_time;
	public Period don_time() {return don_time;}
	
	private Period doff_time;
	public Period doff_time() {return doff_time;}
	// =======================================

	ArmorCategoryEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	protected ArmorCategoryEntity(ArmorCategoryEntity entity) {
		this(entity.name, entity.description);
	}

	@Override public ArmorCategoryEntity clone() {
		return new ArmorCategoryEntity(this);
	}
	@Override public String toString() {
		return String.format(
				"ArmorCategory[name=%s, description=%s]",
				name, description);
	}
	
	public interface InterEffect extends IEffect {
		public String changeName();
		public String changeDescription();
	}
}
