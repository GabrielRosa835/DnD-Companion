package dnd_companion.actors.entities.armor;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.effects.IEffect;

public interface ArmorEffect extends IEffect
{
	public String changeName();
	public Price changePrice();
	public Weight changeWeight();
	public ItemTagEntity[] changeTags();
	public String changeDescription();
	public ArmorCategoryEntity changeCategory();
	public int changeArmorClass();
	public int changeStrengthRequirement();
	public boolean changeStealthDisadvantage();
}
