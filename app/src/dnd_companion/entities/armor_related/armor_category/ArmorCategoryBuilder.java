package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.models.EntityBuilder;

public class ArmorCategoryBuilder implements EntityBuilder 
{	
	private String name = "No name";
	public ArmorCategoryBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	private String description = "No description";
	public ArmorCategoryBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	@Override public ArmorCategoryEntity build() {
		return new ArmorCategoryEntity(name, description);
	}
}
