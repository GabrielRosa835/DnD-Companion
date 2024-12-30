package items;

import java.util.Arrays;

import atomic.Element;
import atomic.currency.CurrencyManager;
import atomic.weight.WeightManager;

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
