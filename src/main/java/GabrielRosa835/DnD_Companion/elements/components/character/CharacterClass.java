package elements.components.character;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)

@Entity
public class CharacterClass
{
	private String name;



	@Override public Action actWith (Action action) {
		return action.source(this);
	}
	@Override public Effect.Applicable applyEffect (Effect effect) {
		return this;
	}
	@Override public Service<?> useService (Service<?> service) {
		return service.loadElements(this);
	}

	public enum BaseTypes {
		ARTIFICER, BARBARIAN, BARD, CLERIC, DRUID, FIGHTER,
		MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK
	}

//		private class Feature {
//		private String name;
//		private String description;
//		private Effect effect;
//		private Actor target;
//		private Timing timing;
//	}
}
