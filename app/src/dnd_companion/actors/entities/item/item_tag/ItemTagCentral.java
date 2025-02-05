package dnd_companion.actors.entities.item.item_tag;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.item.item_tag.data.AdventuringGearTag;
import dnd_companion.actors.entities.item.item_tag.data.AmmunitionTag;
import dnd_companion.actors.entities.item.item_tag.data.ArmorTag;
import dnd_companion.actors.entities.item.item_tag.data.FoodAndDrinkTag;
import dnd_companion.actors.entities.item.item_tag.data.InstrumentTag;
import dnd_companion.actors.entities.item.item_tag.data.MagicalTag;
import dnd_companion.actors.entities.item.item_tag.data.ToolTag;
import dnd_companion.actors.entities.item.item_tag.data.WeaponTag;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class ItemTagCentral implements EntityCentral
{
	private static ItemTagCentral instance;
	private ItemTagCentral() {}
	public static ItemTagCentral use() {
		return instance != null? new ItemTagCentral() : instance;
	}
	
	@Override public ItemTagBuilder builder() {
		return new ItemTagBuilder();
	}
	@Override public ItemTagScheme scheme() {
		return new ItemTagScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.ITEM_TAGS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ItemTagEntity retrieve(String name) {
		return (ItemTagEntity) DataHandler.retrieve(this, name);
	}
	@Override public ItemTagEntity[] data() {
		return Arrays.asList(
				new AdventuringGearTag(),
				new AmmunitionTag(),
				new ArmorTag(),
				new FoodAndDrinkTag(),
				new InstrumentTag(),
				new MagicalTag(),
				new ToolTag(),
				new WeaponTag())
				.toArray(ItemTagEntity[]::new);
	}
}
