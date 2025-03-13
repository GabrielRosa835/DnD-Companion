package fundamentals;

import common.*;
import lombok.*;
import lombok.experimental.*;

@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public enum Dice
{
	D4(4), D6(6), D8(8),
	D10(10), D12(12), D20(20);

	private final int maxValue;
	private final double average;

	private Dice(int maxValue) {
		this.maxValue = maxValue;
		this.average = (double) (maxValue + 1) / 2;
	}

	public int roll() {
		return ToolBox.randomInt(1, maxValue);
	}
}
