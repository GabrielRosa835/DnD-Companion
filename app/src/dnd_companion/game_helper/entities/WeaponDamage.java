package dnd_companion.game_helper.entities;

import dnd_companion.local_storage.structure.components.system.DiceComponent;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;

public class WeaponDamage extends SimpleDamage
{
	private DiceComponent versatile_dice;
	public DiceComponent versatile_dice() {return this.versatile_dice;}
	
	public WeaponDamage(int dice_amount, String dice_name, String damage_type_name, String versatile_dice_name) {
		super(dice_amount, dice_name, damage_type_name);
		this.versatile_dice = new DiceComponent(versatile_dice_name);
	}
	public WeaponDamage(WeaponData data) {
		this(data.damage_dice_amount(), data.damage_dice_type(), data.damage_dice_type(), data.versatile_dice_type());
	}
}
