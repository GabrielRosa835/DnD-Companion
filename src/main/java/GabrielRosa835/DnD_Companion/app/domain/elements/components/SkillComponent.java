package app.domain.elements.components;

import app.domain.elements.entities.*;
import app.domain.elements.options.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@With
public record SkillComponent (
		@JsonIgnore PlayerCharacter backToCharacter,
		Proficiency proficiency,
		Skill type
) implements PlayerCharacter.Property {

	public int modifier() {
		int abilityScoreModifier = backToCharacter.status().get(type.standardAbilityScore()).modifier();
		return (int) (backToCharacter.proficiencyBonus() * proficiency.multiplier()) + abilityScoreModifier;
	}
	public int modifierWith(AbilityScoreType abilityScore) {
		int abilityScoreModifier = backToCharacter.status().get(abilityScore).modifier();
		return (int) (backToCharacter.proficiencyBonus() * proficiency.multiplier()) + abilityScoreModifier;
	}

	public int passive() {return 10 + modifier();}

}
