package GabrielRosa835.components;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)

@Entity
public class CharacterClass
{
	private Type type;

	public enum Type {
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
