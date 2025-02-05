package dnd_companion.actors.entities.armor.category;

import dnd_companion.actors.models.EntityBuilder;

public class ArmorCategoryBuilder implements EntityBuilder
{
	private String name = "No name";
	private String description = "No description";

	ArmorCategoryBuilder() {}

	@Override public ArmorCategoryEntity build() {
		return new ArmorCategoryEntity(name, description);
	}

	public ArmorCategoryBuilder name(String name) {
		this.name = name;
		return this;
	}
	public ArmorCategoryBuilder description(String description) {
		this.description = description;
		return this;
	}
}
