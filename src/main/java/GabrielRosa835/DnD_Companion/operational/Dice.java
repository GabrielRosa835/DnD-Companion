package operational;

import common.*;
import lombok.*;
import lombok.experimental.*;

public interface Dice
{
	static int defaultRoll(int maxValue) {
		return ToolBox.randomInt(1, maxValue);
	}

	int maxValue();
	double average();
	default int roll() {
		return defaultRoll(maxValue());
	}

	@Getter
	@Accessors(fluent = true)
	class Custom implements Dice {
		private final int maxValue;
		private final double average;

		public Custom(int maxValue) {
			this.maxValue = maxValue;
			this.average = (double) (maxValue + 1) / 2;
		}

		@Override public String toString() {
			return "D" + maxValue;
		}
	}

	@Getter
	@Accessors(fluent = true)
	enum Standard implements Dice {
		D4(4), D6(6), D8(8),
		D10(10), D12(12), D20(20);

		private final int maxValue;
		private final double average;

		private Standard(int maxValue) {
			this.maxValue = maxValue;
			this.average = (double) (maxValue + 1) / 2;
		}
	}

}
