package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.addons.models.EntityBuilder;

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
