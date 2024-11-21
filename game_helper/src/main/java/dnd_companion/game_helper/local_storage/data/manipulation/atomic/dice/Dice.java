package dnd_companion.game_helper.local_storage.data.manipulation.atomic.dice;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.Bundle;

public class Dice extends Bundle<DiceElement>
{
	public Dice(DiceElement dice, int amount) {
		this.element = dice;
		this.amount = amount;
	}
}
