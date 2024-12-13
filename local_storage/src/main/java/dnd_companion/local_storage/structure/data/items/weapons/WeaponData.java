package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.ItemData;
import dnd_companion.local_storage.structure.data.items.ItemProperties;
import dnd_companion.local_storage.validation.DataValidator;

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
) implements ItemProperties, ItemData {
	@Override public String collection() {return "weapons";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponData() {
		this(null, 0, null, 0, null, null, null, null, null, 0, null, null, null, null, 0, 0, null, null);
	}
	public WeaponData validate() {
		return (WeaponData) new DataValidator().validate(this).result();
	}
}
