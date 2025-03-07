package elements.components;

import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import operational.*;
import tactics.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class Skill implements Component, Effect.Applicable, Composed {
	private Character character;

	private Type type;
	private int modifier;
	private ProficiencyType proficiency;
	private AbilityScore abilityScore;

	public int rollTestWithAbilityScore(AbilityScore.Type abilityScoreType) {
		AbilityScore abilityScore = character.status().get(abilityScoreType);
		int proficiencyModifier = (int) (character.proficiencyBonus() * proficiency.multiplier()) + abilityScore.modifier();
		return Dice.Standard.D20.roll() + proficiencyModifier;
	}

	public int rollTest() {
		return Dice.Standard.D20.roll() + modifier;
	}

	@RequiredArgsConstructor
	@Getter
	@Accessors(fluent = true)
	public enum Type {
		ATHLETICS(AbilityScore.Type.STRENGTH), ARCANA(AbilityScore.Type.INTELLIGENCE);
		private final AbilityScore.Type defaultAbilityScoreType;
	}

	public Skill applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this).run();
		this.character = e.changeCharacter();
		this.type = e.changeType();
		this.modifier = e.changeModifier();
		this.proficiency = e.changeProficiency();
		this.abilityScore = e.changeAbilityScore();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Character changeCharacter();
		Type changeType();
		int changeModifier();
		ProficiencyType changeProficiency();
		AbilityScore changeAbilityScore();
	}
}
