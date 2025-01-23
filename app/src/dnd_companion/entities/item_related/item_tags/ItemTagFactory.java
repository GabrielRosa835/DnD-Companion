package dnd_companion.entities.item_related.item_tags;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.item_related.item_tags.data.AmmunitionTag;
import dnd_companion.entities.item_related.item_tags.data.ArmorTag;
import dnd_companion.entities.item_related.item_tags.data.MagicalTag;
import dnd_companion.entities.item_related.item_tags.data.WeaponTag;

public class ItemTagFactory implements EntityFactory
{
	ItemTagFactory() {}
	
	@Override public List<Entity> dataList() {
		return Arrays.asList(ammunition(), armor(), magical(), weapon());
	}
	
	public ItemTagEntity ammunition() {
		return new AmmunitionTag();
	}
	public ItemTagEntity armor() {
		return new ArmorTag();
	}
	public ItemTagEntity magical() {
		return new MagicalTag();
	}
	public ItemTagEntity weapon() {
		return new WeaponTag();
	}
}
