package weapon;

import atomic.damage.Damage;
import atomic.weight.Weight;
import dnd.characters.system.coin.Coin;
import items.Item;
import items.ItemTag;

public class Weapon extends Item {
	public Category category;
	public Extent extent;
	public Damage[] damage;
	public Property[] properties;
	public Mastery mastery;
	
	public Weapon(
		Item item,
		String name, 
		ItemTag[] tags, 
		CurrencyBundle price, 
		Weight weight, 
		String description, 
		Category category,
		Extent extent, 
		Damage[] damage, 
		Property[] properties, 
		Mastery mastery
	) {
		super(name, tags, price, weight, description);
		this.category = category;
		this.extent = extent;
		this.damage = damage;
		this.properties = properties;
		this.mastery = mastery;
	}
}
