package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.models.EntityFactory;

public class ArmorCategoryFactory implements EntityFactory
{
	public ArmorCategoryEntity none() {
		return new ArmorCategoryBuilder()
				.name("None")
				.build();
	}
	public ArmorCategoryEntity light() {
		return new ArmorCategoryBuilder()
				.name("Light")
				.build();
	}
	public ArmorCategoryEntity medium() {
		return new ArmorCategoryBuilder()
				.name("Medium")
				.build();
	}
	public ArmorCategoryEntity heavy() {
		return new ArmorCategoryBuilder()
				.name("Heavy")
				.build();
	}
}
