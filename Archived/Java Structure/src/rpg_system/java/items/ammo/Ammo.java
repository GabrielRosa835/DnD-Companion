package items.ammo;

import items.Item;

public interface Ammo extends Item 
{
	public StorageType storage();
	
	public enum StorageType {
		QUIVER, CASE, POUCH;
	}
}