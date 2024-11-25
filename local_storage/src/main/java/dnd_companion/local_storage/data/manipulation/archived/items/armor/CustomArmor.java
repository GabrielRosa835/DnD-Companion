package dnd_companion.local_storage.data.manipulation.archived.items.armor;

import java.util.Arrays;

import dnd_companion.local_storage.data.manipulation.archived.items.Item;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemProperty;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemPropertyCluster;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemTagCluster;
import dnd_companion.local_storage.data.manipulation.price.PriceManager;
import dnd_companion.local_storage.data.manipulation.weight.WeightManager;

public class CustomArmor implements Armor
{
	private String name;
	public String name() {return this.name;}
	
	private ItemPropertyCluster properties;
	public ItemPropertyCluster properties() {return this.properties;}
	
	private ArmorCategory category;
	public ArmorCategory category() {return this.category;}
	
	private int base_ac;
	public int base_ac() {return this.base_ac;}
	
	private int strength_requirement;
	public int strength_requirement() {return this.strength_requirement;}
	
	private boolean stealth_disavantage;
	public boolean stealth_disavantage() {return this.stealth_disavantage;} 
	
	public CustomArmor( 
		String name,
		
		ItemTagCluster tags, 
		PriceManager price, 
		WeightManager weight, 
		String description,
		
		ArmorCategory category, 
		int base_ac, 
		int strength_requirement, 
		boolean stealth_disavantage
	) {
		this.name = name.toUpperCase();
		this.properties = Item.base_properties(tags, price, weight, description);
		this.properties.gather(Arrays.asList(
			new ItemProperty(ItemProperty.Element.ARMOR_CATEGORY,       category),
			new ItemProperty(ItemProperty.Element.BASE_AC,              base_ac),
			new ItemProperty(ItemProperty.Element.STRENGTH_REQUIREMENT, strength_requirement),
			new ItemProperty(ItemProperty.Element.STEALTH_DISAVANTAGE,  stealth_disavantage)
		));
	}
}
