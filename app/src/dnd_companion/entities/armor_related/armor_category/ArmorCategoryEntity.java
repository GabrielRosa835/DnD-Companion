package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.models.Entity;

public class ArmorCategoryEntity implements Entity
{
	private String name;
	@Override public String name() {return name;}
	
	private String description;
	public String description() {return description;}
	
	ArmorCategoryEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	private ArmorCategoryEntity(ArmorCategoryEntity entity) {
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
