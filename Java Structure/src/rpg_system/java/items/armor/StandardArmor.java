package items.armor;

import java.util.Arrays;

import atomic.currency.*;
import atomic.weight.*;

import items.*;

public enum StandardArmor implements Armor
{
	NONE(
		new ItemTagCluster(), new CurrencyManager(), new WeightManager(), "Description :)",
		ArmorCategory.NONE, 10, 0, false
	),
	LEATHER(
		new ItemTagCluster(), 
		new CurrencyManager(Arrays.asList(new CurrencyBundle(Currency.Standard.GOLD, 10))), 
		new WeightManager(Arrays.asList(new WeightMeasure(Weight.Standard.LBS, 10))), 
		"Description :)",
		ArmorCategory.LIGHT, 11, 0, false
	), 
	SCALE_MAIL(
		new ItemTagCluster(), 
		new CurrencyManager(Arrays.asList(new CurrencyBundle(Currency.Standard.GOLD, 50))), 
		new WeightManager(Arrays.asList(new WeightMeasure(Weight.Standard.LBS, 45))), 
		"Description :)",
		ArmorCategory.MEDIUM, 14, 0, true
	), 
	CHAIN_MAIL(
		new ItemTagCluster(), 
		new CurrencyManager(Arrays.asList(new CurrencyBundle(Currency.Standard.GOLD, 75))), 
		new WeightManager(Arrays.asList(new WeightMeasure(Weight.Standard.LBS, 55))), 
		"Description :)",
		ArmorCategory.HEAVY, 16, 13, true
	);
	
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
	
	private StandardArmor( 
		ItemTagCluster tags, 
		CurrencyManager price, 
		WeightManager weight, 
		String description,
		
		ArmorCategory category, 
		int base_ac, 
		int strength_requirement, 
		boolean stealth_disavantage
	) {
		this.properties = Item.base_properties(tags, price, weight, description);
		this.properties.gather(Arrays.asList(
			new ItemProperty(ItemProperty.Options.ARMOR_CATEGORY,       category),
			new ItemProperty(ItemProperty.Options.BASE_AC,              base_ac),
			new ItemProperty(ItemProperty.Options.STRENGTH_REQUIREMENT, strength_requirement),
			new ItemProperty(ItemProperty.Options.STEALTH_DISAVANTAGE,  stealth_disavantage)
		));
	}
}
