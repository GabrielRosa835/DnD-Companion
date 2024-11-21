package dnd_companion.game_helper.local_storage.data.manipulation.weapon;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.damage.Damage;
import dnd_companion.game_helper.local_storage.data.manipulation.items.ItemTag;
import items.Item;

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
