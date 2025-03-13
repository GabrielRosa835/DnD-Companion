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
@Getter
@Accessors(fluent = true)

@Component
public class EffectiveAbilityScoreComposition implements
		Effect.Applicable<EffectiveAbilityScoreComposition>,
		Composition<AbilityScore, EffectiveAbilityScore>,
		Character.Property
{
	private final Character character;

	private Map<AbilityScore, EffectiveAbilityScore> statusMapping = new HashMap<>();

	public EffectiveAbilityScoreComposition add(EffectiveAbilityScore abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}
	public EffectiveAbilityScoreComposition remove(AbilityScore abilityScore) {
		statusMapping.remove(abilityScore);
		return this;
	}
	public EffectiveAbilityScore get(AbilityScore type) {
		return statusMapping.get(type);
	}

	@Override public void applyEffect(Effect<EffectiveAbilityScoreComposition> effect) {
		EffectiveAbilityScoreComposition result = effect.applyTo(this);
		this.statusMapping.putAll(result.statusMapping);
	}
}
