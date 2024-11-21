package dnd_companion.game_helper.local_storage.data.manipulation.items;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.PriceManager;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.WeightManager;

public interface Item extends Element
{
	public ItemPropertyCluster properties();
	
	public static ItemPropertyCluster base_properties(
		ItemTagCluster tags, 
		PriceManager price, 
		WeightManager weight, 
		String description
	) {
		return new ItemPropertyCluster().gather(Arrays.asList(
			new ItemProperty(ItemProperty.Options.TAGS, tags),
			new ItemProperty(ItemProperty.Options.PRICE, price),
			new ItemProperty(ItemProperty.Options.WEIGHT, weight),
			new ItemProperty(ItemProperty.Options.DESCRIPTION, description)
		));
	}
}
