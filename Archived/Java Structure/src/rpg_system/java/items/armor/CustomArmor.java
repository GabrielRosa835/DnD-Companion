package items.armor;

import java.util.Arrays;

import atomic.currency.CurrencyManager;
import atomic.weight.WeightManager;

import items.*;

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
		CurrencyManager price, 
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
			new ItemProperty(ItemProperty.Options.ARMOR_CATEGORY,       category),
			new ItemProperty(ItemProperty.Options.BASE_AC,              base_ac),
			new ItemProperty(ItemProperty.Options.STRENGTH_REQUIREMENT, strength_requirement),
			new ItemProperty(ItemProperty.Options.STEALTH_DISAVANTAGE,  stealth_disavantage)
		));
	}
}
