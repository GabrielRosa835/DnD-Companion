package elements.components.effective;

import elements.entities.options.*;
import elements.models.Component;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)

@Component
public class EffectiveAbilityScore implements Effect.Applicable<EffectiveAbilityScore>
{
	private AbilityScore type;
	private int value;
	private ProficiencyType proficiencySavingThrow;

	public int modifier() {return AbilityScore.calculateModifier(value);}

	public EffectiveAbilityScore(AbilityScore type, int value, ProficiencyType proficiencyType) {
		this.type = type;
		this.value = value;
		if(proficiencyType.isBasicProficiency()) {
			this.proficiencySavingThrow = proficiencyType;
		} else {
			throw new IllegalArgumentException("Proficiency type not allowed");
		}
	}

	@Override public void applyEffect (Effect<EffectiveAbilityScore> effect) {
		EffectiveAbilityScore result = effect.applyTo(this);
		this.type = result.type;
		this.value = result.value;
	}
}
