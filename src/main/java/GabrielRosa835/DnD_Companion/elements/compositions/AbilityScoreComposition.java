package elements.compositions;

import elements.components.character.AbilityScore;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
@Accessors(fluent = true)
public class AbilityScoreComposition implements Effect.Applicable {
	private Map<AbilityScore.Type, AbilityScore> statusMapping = new HashMap<>();

	public AbilityScore get(AbilityScore.Type type) {
		return statusMapping.get(type);
	}

	public AbilityScoreComposition add(AbilityScore abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}

	public AbilityScore strength() {
		return get(AbilityScore.Type.STRENGTH);
	}

	public AbilityScore dexterity() {
		return get(AbilityScore.Type.DEXTERITY);
	}

	public AbilityScore constitution() {
		return get(AbilityScore.Type.CONSTITUTION);
	}

	public AbilityScore intelligence() {
		return get(AbilityScore.Type.INTELLIGENCE);
	}

	public AbilityScore wisdom() {
		return get(AbilityScore.Type.WISDOM);
	}

	public AbilityScore charisma() {
		return get(AbilityScore.Type.CHARISMA);
	}

	public AbilityScoreComposition applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this);
		this.statusMapping = e.changeStatusMapping();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Map<AbilityScore.Type, AbilityScore> changeStatusMapping();
	}
}
