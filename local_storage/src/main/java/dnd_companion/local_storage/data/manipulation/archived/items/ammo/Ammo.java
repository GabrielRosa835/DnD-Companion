package dnd_companion.local_storage.data.manipulation.archived.items.ammo;

import dnd_companion.local_storage.data.manipulation.archived.items.Item;

public interface Ammo extends Item 
{
	public StorageType storage();
	
	public enum StorageType {
		QUIVER, CASE, POUCH;
	}
}