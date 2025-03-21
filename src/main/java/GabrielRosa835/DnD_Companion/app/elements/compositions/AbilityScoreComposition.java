package GabrielRosa835.dnd_companion.app.elements.compositions;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter

// Status
public class AbilityScoreComposition implements
		Effect.Applicable<AbilityScoreComposition>,
		Composition<AbilityScore, AbilityScoreGroup>,
		Character.Property
{
	private Character character;

	@Singular("abilityScore")
	private Map<AbilityScore, AbilityScoreGroup> statusMapping;

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
