package atomic.saving_throw;

import atomic.Proficiency;
import atomic.Technique;
import atomic.ability_score.AbilityScoreGroup;
import main.Character;

public class SavingThrowTechnique extends Technique<SavingThrow>
{
	private AbilityScoreGroup ability_score;
	
	public int modifier() {
		return (int) (this.ability_score.modifier() + (this.character.proficiency_bonus * this.proficiency.multiplier()));
	}
	
	public SavingThrowTechnique(
		Character character,
		AbilityScoreGroup ability_score,
		SavingThrow element,
		Proficiency proficiency
	) {
		super(character, element, proficiency);
		this.ability_score = ability_score;
	}
}