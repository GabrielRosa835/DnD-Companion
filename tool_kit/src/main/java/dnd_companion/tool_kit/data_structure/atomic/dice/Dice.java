package dnd_companion.tool_kit.data_structure.atomic.dice;

import dnd_companion.tool_kit.data_structure.atomic.Bundle;

public class Dice extends Bundle<DiceElement>
{
	public Dice(DiceElement dice, int amount) {
		this.element = dice;
		this.amount = amount;
	}
}
