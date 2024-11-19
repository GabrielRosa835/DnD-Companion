package items;

import java.util.Collection;
import atomic.ElementCluster;

public class ItemTagCluster extends ElementCluster<ItemTag, ItemTagCluster>
{
	public ItemTagCluster() {
		super();
	}
	public ItemTagCluster(Collection<ItemTag> item_tags) {
		super(item_tags);
	}
	public ItemTagCluster(ItemTagCluster item_tag_cluster) {
		super(item_tag_cluster);
	}
}
