package dnd_companion.entities.weapon_related;

import dnd_companion.archives.local_storage.structure.models.ItemData;
import dnd_companion.common.metadata.CollectionREF;

public record WeaponData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description,
	String category,
	String type,
	int    damage_dice_amount,
	String damage_dice_type,
	String damage_type,
	String[] properties,
	String mastery,
	double min_range_value,
	double max_range_value,
	String range_unit,
	String versatile_dice_type
) implements ItemData {
	@Override public CollectionREF collection() {return collections.weapons();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
