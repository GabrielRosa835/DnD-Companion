package app.domain.effects;

import app.domain.elements.options.system.*;

public interface AbilityScoreEffects
{
	static int rollTest(int abilityScoreValue, Dice D20) {
		if (!D20.ID().equals("D20"))
			throw new RuntimeException("Dice should be D20, not a "+D20.name());
		return D20.roll() + calculateModifier(abilityScoreValue);
	}
	static int calculateModifier(int value) {
		return (int) Math.floor(value / 3.0) - 5;
	}
}
