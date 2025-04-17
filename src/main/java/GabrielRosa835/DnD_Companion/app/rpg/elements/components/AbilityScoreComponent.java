package app.rpg.elements.components;

import app.rpg.strategies.operations.CalculateAbilityScoreModifier;
import app.rpg.models.Component;
import app.rpg.elements.options.AbilityScoreOption;
import app.rpg.elements.options.ProficiencyOption;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class AbilityScoreComponent
	implements Component<AbilityScoreComponent>
{
	private ProficiencyOption savingThrowProficiency;
	private AbilityScoreOption type;
	private int value;

	public int modifier() {return CalculateAbilityScoreModifier.with(value);}

	@Override public void update (AbilityScoreComponent clone) {
		this.savingThrowProficiency = clone.savingThrowProficiency;
		this.value = clone.value;
		this.type = clone.type;
	}
}
