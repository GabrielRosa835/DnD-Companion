package dnd_companion.entities.item_related.item_tag;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.item_related.item_tag.data.AdventuringGearTag;
import dnd_companion.entities.item_related.item_tag.data.AmmunitionTag;
import dnd_companion.entities.item_related.item_tag.data.ArmorTag;
import dnd_companion.entities.item_related.item_tag.data.DefaultItemTag;
import dnd_companion.entities.item_related.item_tag.data.FoodAndDrinkTag;
import dnd_companion.entities.item_related.item_tag.data.InstrumentTag;
import dnd_companion.entities.item_related.item_tag.data.MagicalTag;
import dnd_companion.entities.item_related.item_tag.data.ToolTag;
import dnd_companion.entities.item_related.item_tag.data.WeaponTag;

public class ItemTagFactory implements EntityFactory
{
	ItemTagFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(
				adventuringGear(),
				ammunition(),
				armor(),
				foodAndDrink(),
				instrument(),
				magical(),
				tool(),
				weapon());
	}
	@Override public Entity defaultData() {
		return new DefaultItemTag();
	}

	public ItemTagEntity adventuringGear() {
		return new AdventuringGearTag();
	}
	public ItemTagEntity ammunition() {
		return new AmmunitionTag();
	}
	public ItemTagEntity armor() {
		return new ArmorTag();
	}
	public ItemTagEntity foodAndDrink() {
		return new FoodAndDrinkTag();
	}
	public ItemTagEntity instrument() {
		return new InstrumentTag();
	}
	public ItemTagEntity magical() {
		return new MagicalTag();
	}
	public ItemTagEntity tool() {
		return new ToolTag();
	}
	public ItemTagEntity weapon() {
		return new WeaponTag();
	}
}
