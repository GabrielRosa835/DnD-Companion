package items.ammo;

import java.util.Arrays;

import atomic.currency.Currency;
import atomic.currency.CurrencyBundle;
import atomic.currency.CurrencyManager;
import atomic.weight.Weight;
import atomic.weight.WeightManager;
import atomic.weight.WeightMeasure;
import items.Item;
import items.ItemPropertyCluster;
import items.ItemTagCluster;

public enum StandardAmmo 
{
	ARROW(
		new ItemTagCluster(), 
		new CurrencyManager(Arrays.asList(new CurrencyBundle(Currency.Standard.COPPER, 5))), 
		new WeightManager(Arrays.asList(new WeightMeasure(Weight.Standard.OZ, 0.8))), 
		"""
		Arrows are used with a weapon that has the ammunition property to make a ranged attack.
		Each time you attack with the weapon, you expend one piece of ammunition.
		Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon).
		At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.

		Arrows are typically stored in a Quiver (bought separately).
		"""
	), 
	BOLTS(
		new ItemTagCluster(), 
		new CurrencyManager(Arrays.asList(new CurrencyBundle(Currency.Standard.COPPER, 5))), 
		new WeightManager(Arrays.asList(new WeightMeasure(Weight.Standard.OZ, 1.2))), 
		"""
		Crossbow bolts are used with a weapon that has the ammunition property to make a ranged attack. 
		Each time you attack with the weapon, you expend one piece of ammunition. 
		Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). 
		At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.

		Bolts are typically stored in a Crossbow Bolt Case (bought separately).
		"""
	);
	
	private ItemPropertyCluster properties;
	public ItemPropertyCluster properties() {return this.properties;}
	
	private StandardAmmo(
		ItemTagCluster tags, 
		CurrencyManager price, 
		WeightManager weight, 
		String description
	) {
		this.properties = Item.base_properties(tags, price, weight, description);
	}
}
