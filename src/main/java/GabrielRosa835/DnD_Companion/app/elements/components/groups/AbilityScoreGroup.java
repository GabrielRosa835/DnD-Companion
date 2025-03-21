package GabrielRosa835.dnd_companion.app.elements.components.groups;


import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import GabrielRosa835.dnd_companion.app.tactics.operations.ability_score.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class AbilityScoreGroup implements
		Effect.Applicable<AbilityScoreGroup>
{
	private ProficiencyType savingThrowProficiency;
	private AbilityScore type;
	private int value;

	public int modifier() {return CalculateAbilityScoreModifier.with(value);}

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
