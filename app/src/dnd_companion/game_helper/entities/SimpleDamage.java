package dnd_companion.game_helper.entities;

import dnd_companion.local_storage.structure.components.system.DamageTypeComponent;
import dnd_companion.local_storage.structure.components.system.DiceComponent;

public class SimpleDamage
{
	private int dice_amount;
	public int dice_amount() {return this.dice_amount;}

	private DiceComponent dice;
	public DiceComponent dice() {return this.dice;}

	private DamageTypeComponent type;
	public DamageTypeComponent type() {return this.type;}

	public SimpleDamage(int dice_amount, String dice_name, String damage_type_name) {
		this.dice_amount = dice_amount;
		this.dice = new DiceComponent(dice_name);
		this.type = new DamageTypeComponent(damage_type_name);
	}
}
