package dnd_companion.game_helper.local_storage.data.manipulation.items.ammo;

import dnd_companion.game_helper.local_storage.data.manipulation.items.Item;

public interface Ammo extends Item 
{
	public StorageType storage();
	
	public enum StorageType {
		QUIVER, CASE, POUCH;
	}
}