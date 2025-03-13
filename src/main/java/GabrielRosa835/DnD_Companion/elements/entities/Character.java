package elements.entities;

import elements.components.Health;
import elements.compositions.*;
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

	private EffectiveAbilityScoreComposition status;
	private EffectiveSkillComposition skills;
	private EffectiveCharacterClassComposition classes;

	private int proficiencyBonus;

	public Character applyEffect (Effect<Character> effect) {
		Character result = effect.applyTo(this);
		this.name = result.name;
		this.health = result.health;
		this.status = result.status;
		this.skills = result.skills;
		this.classes = result.classes;
		return this;
	}

	public interface Property {
		Character character();
	}
}
