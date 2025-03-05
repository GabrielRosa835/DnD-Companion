package GabrielRosa835.components;

import lombok.*;

public interface Dice
{
	int roll();

	static int defaultRoll(int maxValue) {
		return (int) ((maxValue - 1) * Math.random()) + 1;
	}

	@AllArgsConstructor
	class Custom implements Dice {
		private int maxValue;
		@Override public int roll() {return Dice.defaultRoll(maxValue);}
		@Override public String toString() {return "D" + maxValue;}
	}

	@RequiredArgsConstructor
	enum Standard implements Dice {
		D4(4), D6(6), D8(8),
		D10(10), D12(12), D20(20);
		private final int maxValue;
		@Override public int roll() {return Dice.defaultRoll(maxValue);}
	}

}
