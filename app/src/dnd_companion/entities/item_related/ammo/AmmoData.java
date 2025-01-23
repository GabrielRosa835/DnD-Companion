package dnd_companion.entities.item_related.ammo;

import dnd_companion.archives.local_storage.structure.models.ItemData;
import dnd_companion.common.metadata.CollectionREF;

public record AmmoData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements ItemData {
	@Override public CollectionREF collection() {return collections.ammunitions();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
