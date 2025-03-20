package elements.compositions;

import elements.components.groups.*;
import elements.entities.character.AbilityScore;
import elements.entities.character.Character;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter

// Status
public class AbilityScoreComposition implements
		Effect.Applicable<AbilityScoreComposition>,
		Composition<AbilityScore, AbilityScoreGroup>,
		Character.Property
{
	private final Character character;

	@Singular("abilityScore")
	private Map<AbilityScore, AbilityScoreGroup> statusMapping = new HashMap<>();

	@Override
	public AbilityScoreComposition add(AbilityScoreGroup abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}
	@Override
	public AbilityScoreComposition remove(AbilityScore abilityScore) {
		statusMapping.remove(abilityScore);
		return this;
	}
	@Override
	public AbilityScoreGroup get(AbilityScore type) {
		return statusMapping.get(type);
	}

	@Override
	public AbilityScoreComposition applyEffect(Effect<AbilityScoreComposition> effect) {
		var result = effect.applyTo(this);
		this.statusMapping = result.statusMapping;
		return this;
	}
}
