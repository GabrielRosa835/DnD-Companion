package elements.compositions;

import elements.components.groups.*;
import elements.entities.character.AbilityScore;
import elements.entities.character.Character;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

import java.util.*;
import java.util.function.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter

// Status
public class AbilityScoreComposition implements
		Effectable<AbilityScoreComposition>,
		Character.Property
{
	private final Character character;
	private ResistanceComposition<AbilityScoreComposition> resistances;

	@Singular("abilityScore")
	private Map<AbilityScore, AbilityScoreGroup> elements = new HashMap<>();

	@Override
	public void applyEffect (
			Effect<AbilityScoreComposition> effect, ResistanceComposition<AbilityScoreComposition> resistances
	) {
		var result = effect.applyTo(this, resistances);
		this.elements = result.elements;
	}
}
