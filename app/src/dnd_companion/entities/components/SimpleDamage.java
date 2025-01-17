package dnd_companion.entities.components;

import dnd_companion.archives.game_helper.actors.entities.system.DamageTypeEntity;
import dnd_companion.archives.game_helper.actors.entities.system.DiceEntity;

public class SimpleDamage
{
	private int dice_amount;
	public int dice_amount() {return this.dice_amount;}

	private DiceEntity dice;
	public DiceEntity dice() {return this.dice;}

	private DamageTypeEntity type;
	public DamageTypeEntity type() {return this.type;}

	public SimpleDamage(int dice_amount, String dice_name, String damage_type_name) {
		this.dice_amount = dice_amount;
		this.dice = new DiceEntity(dice_name);
		this.type = new DamageTypeEntity(damage_type_name);
	}
}
