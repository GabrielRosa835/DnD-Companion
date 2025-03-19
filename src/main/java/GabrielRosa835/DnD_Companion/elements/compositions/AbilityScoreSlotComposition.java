package elements.compositions;

import elements.components.slots.*;
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

// Status
public class AbilityScoreSlotComposition implements
		Effect.Applicable<AbilityScoreSlotComposition>,
		Composition<AbilityScore, AbilityScoreSlot>,
		Character.Property
{
	private final Character character;

	@Singular("abilityScore")
	private Map<AbilityScore, AbilityScoreSlot> statusMapping = new HashMap<>();

	@Override
	public AbilityScoreSlotComposition add(AbilityScoreSlot abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}
	@Override
	public AbilityScoreSlotComposition remove(AbilityScore abilityScore) {
		statusMapping.remove(abilityScore);
		return this;
	}
	@Override
	public AbilityScoreSlot get(AbilityScore type) {
		return statusMapping.get(type);
	}

	@Override
	public AbilityScoreSlotComposition applyEffect(Effect<AbilityScoreSlotComposition> effect) {
		var result = effect.applyTo(this);
		this.statusMapping = result.statusMapping;
		return this;
	}
}
