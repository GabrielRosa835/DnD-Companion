package elements.compositions;

import elements.components.effective.*;
import elements.entities.Character;
import elements.entities.options.*;
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
public class EffectiveAbilityScoreComposition implements
		Effect.Applicable<EffectiveAbilityScoreComposition>,
		Composition<AbilityScore, EffectiveAbilityScore>,
		Character.Property
{
	private final Character character;

	@Singular("abilityScore")
	private Map<AbilityScore, EffectiveAbilityScore> statusMapping = new HashMap<>();

	@Override
	public EffectiveAbilityScoreComposition add(EffectiveAbilityScore abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}
	@Override
	public EffectiveAbilityScoreComposition remove(AbilityScore abilityScore) {
		statusMapping.remove(abilityScore);
		return this;
	}
	@Override
	public EffectiveAbilityScore get(AbilityScore type) {
		return statusMapping.get(type);
	}

	@Override
	public EffectiveAbilityScoreComposition applyEffect(Effect<EffectiveAbilityScoreComposition> effect) {
		var result = effect.applyTo(this);
		this.statusMapping.putAll(result.statusMapping);
		return this;
	}
}
