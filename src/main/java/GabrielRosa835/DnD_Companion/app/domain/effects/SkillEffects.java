package app.domain.effects;

import app.domain.elements.options.system.*;

public interface SkillEffects {

	static int rollSkillTest(int modifier, Dice D20) {
		if (!D20.ID().equals("D20"))
			throw new RuntimeException("Dice should be a D20, not a "+D20.name());
		return D20.roll() + modifier;
	}


	public int modifier() {
		int abilityScoreModifier = backToCharacter.status().get(type.standardAbilityScore()).modifier();
		return (int) (backToCharacter.proficiencyBonus() * proficiencyType.multiplier()) + abilityScoreModifier;
	}
	public int modifierWith(AbilityScoreType abilityScore) {
		int abilityScoreModifier = backToCharacter.status().get(abilityScore).modifier();
		return (int) (backToCharacter.proficiencyBonus() * proficiencyType.multiplier()) + abilityScoreModifier;
	}
	public int passive() {return 10 + modifier();}

}
