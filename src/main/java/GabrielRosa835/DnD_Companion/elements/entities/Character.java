package elements.entities;

import elements.components.Health;
import elements.compositions.*;
import lombok.*;
import lombok.experimental.*;
import tactics.Effect;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class Character implements Effect.Applicable<Character>
{
	private String name;
	private Health health;

	private EffectiveCharacterClassComposition classes;
	private EffectiveAbilityScoreComposition status;
	private EffectiveSkillComposition skills;

	private int proficiencyBonus;

	@Override
	public Character applyEffect (Effect<Character> effect) {
		Character result = effect.applyTo(this);
		this.classes = result.classes;
		this.health = result.health;
		this.status = result.status;
		this.skills = result.skills;
		this.name = result.name;
		return this;
	}

	public interface Property {
		Character character();
	}
}
