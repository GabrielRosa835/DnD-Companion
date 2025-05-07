package app.domain.elements.components.playerCharacter;

import app.domain.elements.entities.*;
import app.domain.elements.options.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@With
public record HealthPlayerComponent (
		int maximumHitPoints,
		int currentHitPoints,
		int temporaryHitPoints,
		DeathSaveComponent[] deathSaves,
		Dice hitDiceType,
		int hitDiceLeft,
		@JsonIgnore PlayerCharacter backToCharacter
) implements PlayerCharacter.Property {

//	public int hitDiceMaximum() {
//		return PlayerClassEffects.calculateTotalLevel(backToCharacter.classes().values());
//	}

}