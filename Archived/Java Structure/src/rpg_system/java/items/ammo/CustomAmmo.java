package items.ammo;

import java.util.Arrays;

import atomic.currency.CurrencyManager;
import atomic.weight.WeightManager;
import items.*;

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
			new ItemProperty(ItemProperty.Options.STORAGE_TYPE, storage)
		));
	}
}