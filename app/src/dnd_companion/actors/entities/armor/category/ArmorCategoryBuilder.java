package dnd_companion.actors.entities.armor.category;

import dnd_companion.actors.models.IEntityBuilder;

public class ArmorCategoryBuilder implements IEntityBuilder
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
