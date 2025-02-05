package dnd_companion.actors.entities.armor.category;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.armor.category.data.HeavyArmor;
import dnd_companion.actors.entities.armor.category.data.LightArmor;
import dnd_companion.actors.entities.armor.category.data.MediumArmor;
import dnd_companion.actors.entities.armor.category.data.NoArmor;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class ArmorCategoryCentral implements EntityCentral
{
	private static ArmorCategoryCentral instance;
	private ArmorCategoryCentral() {}
	public static ArmorCategoryCentral use() {
		return instance != null? new ArmorCategoryCentral() : instance;
	}
	
	@Override public ArmorCategoryBuilder builder() {
		return new ArmorCategoryBuilder();
	}
	@Override public ArmorCategoryScheme scheme() {
		return new ArmorCategoryScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.ARMOR_CATEGORIES;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ArmorCategoryEntity retrieve(String entity_name) {
		return (ArmorCategoryEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public ArmorCategoryEntity[] data() {
		return Arrays.asList(
				new HeavyArmor(),
				new LightArmor(),
				new MediumArmor(),
				new NoArmor())
				.toArray(ArmorCategoryEntity[]::new);
	}
}
