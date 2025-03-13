package elements.components.character;

import fundamentals.Dice;
import fundamentals.ProficiencyType;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class Skill
{
	private Character character;

	private String name;
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

	@Override public Action actWith (Action action) {
		return action.source(this);
	}
	@Override public Service<?> useService (Service<?> service) {
		return service.loadElements(this);
	}
	@Override public Skill applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect.target(this).execute();
		this.character = e.changeCharacter();
		this.name = e.changeName();
		this.modifier = e.changeModifier();
		this.proficiency = e.changeProficiency();
		this.abilityScore = e.changeAbilityScore();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Character changeCharacter();
		String changeName();
		int changeModifier();
		ProficiencyType changeProficiency();
		AbilityScore changeAbilityScore();
	}
}
