package dnd_companion.entities.armor_related.armor_category;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.armor_related.armor_category.data.HeavyArmor;
import dnd_companion.entities.armor_related.armor_category.data.LightArmor;
import dnd_companion.entities.armor_related.armor_category.data.MediumArmor;
import dnd_companion.entities.armor_related.armor_category.data.NoArmor;

public class ArmorCategoryFactory implements EntityFactory
{
	ArmorCategoryFactory() {}
	
	@Override public List<Entity> dataList() {
		return Arrays.asList(none(), light(), medium(), heavy());
	}
	
	public ArmorCategoryEntity none() {
		return new NoArmor();
	}
	public ArmorCategoryEntity light() {
		return new LightArmor();
	}
	public ArmorCategoryEntity medium() {
		return new MediumArmor();
	}
	public ArmorCategoryEntity heavy() {
		return new HeavyArmor();
	}
}
