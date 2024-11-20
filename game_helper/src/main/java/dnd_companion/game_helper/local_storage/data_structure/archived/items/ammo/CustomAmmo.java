package dnd_companion.game_helper.local_storage.data_structure.archived.items.ammo;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.currency.CurrencyManager;
import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.weight.WeightManager;
import dnd_companion.game_helper.local_storage.data_structure.archived.items.Item;
import dnd_companion.game_helper.local_storage.data_structure.archived.items.ItemProperty;
import dnd_companion.game_helper.local_storage.data_structure.archived.items.ItemPropertyCluster;
import dnd_companion.game_helper.local_storage.data_structure.archived.items.ItemTagCluster;

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
		CurrencyManager price, 
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