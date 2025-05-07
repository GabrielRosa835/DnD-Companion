package app.domain.effects;

import app.domain.elements.options.*;

public interface SkillEffects {

	static int rollSkillTest(int modifier, Dice D20) {
		if (!D20.ID().equals("D20"))
			throw new RuntimeException("Dice should be a D20, not a "+D20.name());
		return D20.roll() + modifier;
	}

}
