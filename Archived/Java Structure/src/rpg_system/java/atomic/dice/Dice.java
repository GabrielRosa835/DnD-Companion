package atomic.dice;

import atomic.Bundle;

public class Dice extends Bundle<DiceElement>
{
	public Dice(DiceElement dice, int amount) {
		this.element = dice;
		this.amount = amount;
	}
}
