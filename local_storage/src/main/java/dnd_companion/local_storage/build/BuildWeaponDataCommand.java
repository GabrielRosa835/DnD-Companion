package dnd_companion.local_storage.build;

import dnd_companion.local_storage.structure.components.items.*;
import dnd_companion.local_storage.structure.components.items.weapons.WeaponRange;
import dnd_companion.local_storage.structure.components.system.Damage;
import dnd_companion.local_storage.structure.components.system.Dice;
import dnd_companion.local_storage.structure.components.system.units.Length;
import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;

public class BuildWeaponDataCommand extends DataBuilderCommand<WeaponData>
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTag[] tags;
	private String description;
	private WeaponCategory category;
	private WeaponType type;
	private WeaponProperty[] properties;
	private WeaponMastery mastery;
	private Damage damage;
	private WeaponRange range;
	private Ammo ammo;
	private Dice versatile_dice;

	public BuildWeaponDataCommand(
		String name,
		Price price,
		Weight weight,
		ItemTag[] tags,
		String description,
		String category,
		String type,
		Damage damage,
		String[] properties,
		String mastery,
		Length min_range,
		Length max_range,
		String versatile_dice) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
		this.category = category;
		this.type = type;
		this.damage_dice_type = damage_dice_type;
		this.damage_dice_amount = damage_dice_amount;
		this.damage_type = damage_type;
		this.properties = properties;
		this.mastery = mastery;
		this.min_range = min_range;
		this.max_range = max_range;
		this.versatile_dice = versatile_dice;
	}



}
