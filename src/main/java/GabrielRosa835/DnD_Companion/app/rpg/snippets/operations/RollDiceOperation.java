package app.rpg.snippets.operations;

import app.rpg.elements.options.dices.DiceOption;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RollDiceOperation
		implements Operation<Integer> {
	private int maxValue;

	public static RollDiceOperation with(String diceName) {
		int maxValue = GetDiceMaxValueOperation.with(diceName);
		return new RollDiceOperation(maxValue);
	}

	public static RollDiceOperation with(DiceOption dice) {
		int maxValue = dice.maxValue();
		return new RollDiceOperation(maxValue);
	}

	public static RollDiceOperation with(int diceMaxValue) {
		return new RollDiceOperation(diceMaxValue);
	}

	public Integer process() {
		return
	}
}
