package dnd_companion.local_storage.data.manipulation.archived.atomic.dice;

import dnd_companion.local_storage.data.manipulation.archived.atomic.Bundle;

public class Dice extends Bundle<DiceElement>
{
	public Dice(DiceElement dice, int amount) {
		this.element = dice;
		this.amount = amount;
	}
}
