package dnd_companion.local_storage.data.manipulation.archived.items;

import java.util.Collection;

import atomic.ElementCluster;

public class ItemPropertyCluster extends ElementCluster<ItemProperty, ItemPropertyCluster>
{
	public ItemPropertyCluster() {
		super();
	}
	public ItemPropertyCluster(Collection<ItemProperty> item_properties) {
		super(item_properties);
	}
	public ItemPropertyCluster(ItemPropertyCluster item_property_cluster) {
		super(item_property_cluster);
	}
}
