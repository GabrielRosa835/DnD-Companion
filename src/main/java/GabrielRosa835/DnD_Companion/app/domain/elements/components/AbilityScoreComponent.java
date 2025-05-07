package app.domain.elements.components;

import app.domain.elements.entities.*;
import app.domain.elements.options.*;
import app.storage.reference.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import static app.domain.effects.AbilityScoreEffects.*;

@With
public record AbilityScoreComponent (
		@JsonIgnore PlayerCharacter backToCharacter,
		@AsReference Proficiency savingThrowProficiency,
		@AsReference AbilityScoreType type,
		int value
) implements PlayerCharacter.Property {

	public int modifier() {
		return calculateModifier(value);
	}

	public int saveModifier() {
		return (int) (savingThrowProficiency.multiplier() * backToCharacter.proficiencyBonus()) + modifier();
	}

}
