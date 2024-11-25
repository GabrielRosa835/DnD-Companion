package dnd_companion.local_storage.data.manipulation.archived.items.ammo;

import java.util.Arrays;

import atomic.currency.CurrencyBundle;
import dnd_companion.local_storage.data.manipulation.archived.items.Item;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemPropertyCluster;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemTagCluster;
import dnd_companion.local_storage.data.manipulation.price.PriceManager;
import dnd_companion.local_storage.data.manipulation.weight.Weight;
import dnd_companion.local_storage.data.manipulation.weight.WeightManager;

public enum StandardAmmo 
{
	ARROW(
		new ItemTagCluster(), 
		new PriceManager(Arrays.asList(new CurrencyBundle(Currency.Standard.COPPER, 5))), 
		new WeightManager(Arrays.asList(new Weight(Weight.Standard.OZ, 0.8))), 
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
		new PriceManager(Arrays.asList(new CurrencyBundle(Currency.Standard.COPPER, 5))), 
		new WeightManager(Arrays.asList(new Weight(Weight.Standard.OZ, 1.2))), 
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
		PriceManager price, 
		WeightManager weight, 
		String description
	) {
		this.properties = Item.base_properties(tags, price, weight, description);
	}
}
