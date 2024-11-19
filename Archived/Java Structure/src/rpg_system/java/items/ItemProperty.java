package items;

import atomic.Element;

public class ItemProperty implements Element
{
	private Options option;
	public Options option() {return this.option;}
	public String name() {return this.option.name();}
	
	private Object property;
	public Object property() {return this.property;}

	public ItemProperty(Options option, Object property) {
		this.option = option;
		this.property = property;
	}
	
	public enum Options {
		// Base properties
		TAGS, PRICE, WEIGHT, DESCRIPTION,
		
		// Armor properties
		ARMOR_CATEGORY, BASE_AC, STRENGTH_REQUIREMENT, STEALTH_DISAVANTAGE,
		
		// Ammo storage type
		STORAGE_TYPE
	}
}
