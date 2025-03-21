package GabrielRosa835.dnd_companion.app.fundamentals;

import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import lombok.*;
import lombok.experimental.*;

@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public enum ProficiencyType {
	NONE(0), HALF(0.5), NORMAL(1), EXPERTISE(2);
	private final double multiplier;

	public boolean isBasicProficiency() {
		return this == NONE | this == NORMAL;
	}

	public int proficiencyModifier(Character character) {
		return (int) (character.keyProperties().proficiencyBonus() * this.multiplier);
	}
}
