package dnd_companion.local_storage.data.manipulation.archived.items.armor;

import dnd_companion.local_storage.data.manipulation.archived.items.Item;

public interface Armor extends Item 
{
	public ArmorCategory category();
	public int base_ac();
	public int strength_requirement();
	public boolean stealth_disavantage();

	public enum ArmorCategory {NONE, LIGHT, MEDIUM, HEAVY, SHIELD}
}
