package dnd_companion.entities.components;

import dnd_companion.archives.game_helper.actors.entities.system.DiceEntity;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponData;

public class WeaponDamage extends SimpleDamage
{
	private DiceEntity versatile_dice;
	public DiceEntity versatile_dice() {return this.versatile_dice;}
	
	public WeaponDamage(int dice_amount, String dice_name, String damage_type_name, String versatile_dice_name) {
		super(dice_amount, dice_name, damage_type_name);
		this.versatile_dice = new DiceEntity(versatile_dice_name);
	}
	public WeaponDamage(WeaponData data) {
		this(data.damage_dice_amount(), data.damage_dice_type(), data.damage_dice_type(), data.versatile_dice_type());
	}
}
