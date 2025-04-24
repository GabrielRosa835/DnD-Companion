package app.rpg.elements.options.dices;

import app.rpg.elements.models.*;
import app.rpg.snippets.operations.*;
import app.storage.*;
import co.unruly.control.result.*;

import java.util.*;
import java.util.function.*;

import static co.unruly.control.result.Introducers.tryTo;
import static co.unruly.control.result.Resolvers.ifFailed;
import static co.unruly.control.result.Transformers.attempt;
import static co.unruly.control.result.Transformers.onFailure;
import static java.util.function.UnaryOperator.identity;

public record DiceOption(
		String name,
		int maxValue,
		double average
) implements Option {
	public DiceOption(int maxValue) {
		this("D" + maxValue, maxValue, (double) (maxValue + 1) / 2);
	}

	public int roll() {
		return (int) ((maxValue - 1) * Math.random()) + 1;
	}

	public static DiceOption get(String name) {
		return Result.success(name)
				.then(attempt(tryTo(n -> Database.get().retrieve("Dice Types", n, DiceOption.class))))
				.then(ifFailed(e -> new DiceOption(getMaxValueFromName(name))));
	}

	public static final DiceOption[] fixed = new DiceOption[]{
			DICE_D4.use,
			DICE_D6.use,
			DICE_D8.use,
			DICE_D10.use,
			DICE_D12.use,
			DICE_D20.use
	};

	public static int getMaxValueFromName (String name) {
		if (name == null || !name.matches("D\\d+")) {
			throw new IllegalArgumentException("Not a valid dice:" + name);
		}
		return Integer.parseInt(name.substring(1));
	}
}
