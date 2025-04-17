package elements.components.groups;

import elements.entities.character.AbilityScore;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class AbilityScoreGroup implements Effect.Applicable<AbilityScoreGroup>
{
	private ProficiencyType savingThrowProficiency;
	private AbilityScore type;
	private int value;

	public int modifier() {return AbilityScore.calculateModifier(value);}

	private AbilityScoreGroup (ProficiencyType savingThrowProficiency, AbilityScore type, int value) {
		this.type = type;
		this.value = value;
		if(savingThrowProficiency.isBasicProficiency()) {
			this.savingThrowProficiency = savingThrowProficiency;
		} else {
			throw new IllegalArgumentException("Proficiency type not allowed");
		}
	}

	@Override
	public AbilityScoreGroup applyEffect (Effect<AbilityScoreGroup> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.value = result.value;
		return this;
	}
}
