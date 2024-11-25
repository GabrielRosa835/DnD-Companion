package dnd_companion.local_storage.data.manipulation.archived.items.ammo;

import java.util.Arrays;

import dnd_companion.local_storage.data.manipulation.archived.items.Item;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemProperty;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemPropertyCluster;
import dnd_companion.local_storage.data.manipulation.archived.items.ItemTagCluster;
import dnd_companion.local_storage.data.manipulation.price.PriceManager;
import dnd_companion.local_storage.data.manipulation.weight.WeightManager;

public class CustomAmmo implements Ammo
{
	private String name;
	public String name() {return name;}
	
	private ItemPropertyCluster properties;
	public ItemPropertyCluster properties() {return this.properties;}
	
	private StorageType storage;
	public StorageType storage() {return this.storage;}
	
	public CustomAmmo(
		String name,
		ItemTagCluster tags, 
		PriceManager price, 
		WeightManager weight,
		StorageType storage,
		String description
	) {
		this.name = name.toUpperCase();
		this.properties = Item.base_properties(tags, price, weight, description);
		this.properties.gather(Arrays.asList(
			new ItemProperty(ItemProperty.Element.STORAGE_TYPE, storage)
		));
	}
}