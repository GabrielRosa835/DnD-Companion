package app.domain.effects;

import app.infrastructure.exceptions.*;

public interface DiceEffects
{

	public double average () {
		return (double) (maxValue + 1) / 2;
	}

	public int roll() {
		return (int) ((maxValue - 1) * Math.random()) + 1;
	}

	public static Result<app.domain.elements.entities.options.system.DiceMapping, IllegalArgumentException> of (String name, String description) {
		if (name == null || !name.matches("D\\d+")) {
			return Result.failure(new IllegalArgumentException("Not a valid dice: " + name));
		}
		int maxValue = Integer.parseInt(name.substring(1));
		return Result.success(app.domain.elements.entities.options.system.DiceMapping.create(maxValue, description));
	}
}
