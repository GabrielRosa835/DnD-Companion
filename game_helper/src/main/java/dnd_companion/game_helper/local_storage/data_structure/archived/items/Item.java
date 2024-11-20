package dnd_companion.game_helper.local_storage.data_structure.archived.items;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.currency.CurrencyManager;
import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.weight.WeightManager;

public interface Item extends Element
{
	public ItemPropertyCluster properties();
	
	public static ItemPropertyCluster base_properties(
		ItemTagCluster tags, 
		CurrencyManager price, 
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
