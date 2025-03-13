package elements.components.effective;

import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class EffectiveAbilityScore implements Effect.Applicable<EffectiveAbilityScore>
{
	private ProficiencyType proficiencySavingThrow;
	private AbilityScore type;
	private int value;

	public int modifier() {return AbilityScore.calculateModifier(value);}

	private EffectiveAbilityScore(ProficiencyType proficiencySavingThrow, AbilityScore type, int value) {
		this.type = type;
		this.value = value;
		if(proficiencySavingThrow.isBasicProficiency()) {
			this.proficiencySavingThrow = proficiencySavingThrow;
		} else {
			throw new IllegalArgumentException("Proficiency type not allowed");
		}
	}

	@Override
	public EffectiveAbilityScore applyEffect (Effect<EffectiveAbilityScore> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.value = result.value;
		return this;
	}
}
