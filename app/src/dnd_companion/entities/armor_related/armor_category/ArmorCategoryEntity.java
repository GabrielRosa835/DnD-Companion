package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.addons.components.measure.Period;
import dnd_companion.entities.addons.models.Entity;

public class ArmorCategoryEntity implements Entity
{
	private String name;
	@Override public String name() {return name;}

	private String description;
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
}
