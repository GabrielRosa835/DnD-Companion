package elements.entities;

import elements.components.character.Health;
import elements.compositions.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.Effect;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
@Accessors(fluent = true)
public class Character implements Effect.Applicable<Character>
{
	private String name;
	private Health health;

	private AbilityScoreComposition status;
	private SkillComposition skills;
	private EffectiveCharacterClassComposition classes;

	private int proficiencyBonus;

	@Override public void applyEffect (Effect<Character> effect) {
		Character result = effect.apply(this);
		this.name = result.name;
		this.health = result.health;
	}
}
