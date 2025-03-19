package elements.components.slots;

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
public class AbilityScoreSlot implements Effect.Applicable<AbilityScoreSlot>
{
	private ProficiencyType savingThrowProficiency;
	private AbilityScore type;
	private int value;

	public int modifier() {return AbilityScore.calculateModifier(value);}

	private AbilityScoreSlot(ProficiencyType savingThrowProficiency, AbilityScore type, int value) {
		this.type = type;
		this.value = value;
		if(savingThrowProficiency.isBasicProficiency()) {
			this.savingThrowProficiency = savingThrowProficiency;
		} else {
			throw new IllegalArgumentException("Proficiency type not allowed");
		}
	}

	@Override
	public AbilityScoreSlot applyEffect (Effect<AbilityScoreSlot> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.value = result.value;
		return this;
	}
}
