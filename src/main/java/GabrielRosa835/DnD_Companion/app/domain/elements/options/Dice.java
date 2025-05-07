package app.domain.elements.options;

import app.domain.elements.models.*;

public record Dice(
		String ID,
		int maxValue,
		double average
) implements Option {

	@Override public String name() {return String.format("D%d", maxValue);}
	public Dice(int maxValue) {this("D" + maxValue, maxValue, (double) (maxValue + 1) / 2);}
	public int roll() {
		return (int) ((maxValue - 1) * Math.random()) + 1;
	}

}
