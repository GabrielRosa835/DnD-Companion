package dnd_companion.local_storage.archived.components.main.life;

import dnd_companion.local_storage.structure.components.system.DiceComponent;

public class HitDice
{
	public int dice_ammount;
	public DiceComponent dice_type;

	public int use_dice()
	{
		if(dice_ammount == 0) {
			throw new RuntimeException("Não há dados sobrando");
		} else {
			dice_ammount--;
			return dice_type.roll();
		}
	}

	public HitDice(int dice_ammount, DiceComponent dice_type)
	{
		this.dice_ammount = dice_ammount;
		this.dice_type = dice_type;
	}
}
