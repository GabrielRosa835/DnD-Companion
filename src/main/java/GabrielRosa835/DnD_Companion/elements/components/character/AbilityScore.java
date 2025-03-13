package elements.components.character;

import elements.models.Component;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)

@Component
public class AbilityScore implements Effect.Applicable<AbilityScore>
{
	private String type;
	private int value;
	private int modifier; // floor(value/3) - 5

	private void calculateModifier() {
		this.modifier = (int) Math.floor(value / 3) - 5;
	}

	private boolean savingThrowProficiency;





	public int rollTestWithProficiency(boolean proficiency) {
		int proficiencyModifier = proficiency ? character.proficiencyBonus() : 0;
		return rollTest() + proficiencyModifier;
	}

	public int rollSave() {
		return rollTestWithProficiency(savingThrowProficiency);
	}

	@Override public Action actWith (Action action) {
		return null;
	}
	@Override public Service<?> useService (Service<?> service) {
		return service.loadElements(this).execute();
	}

	@Override public void applyEffect (Effect<AbilityScore> effect) {
		AbilityScore result = effect.apply(this);
		this.type = result.type;
		this.value = result.value;
		this.modifier = calculateModifier();
	}
}
