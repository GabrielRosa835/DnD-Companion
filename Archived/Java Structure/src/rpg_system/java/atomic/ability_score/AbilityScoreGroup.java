package atomic.ability_score;

import atomic.Group;

public class AbilityScoreGroup extends Group<AbilityScoreElement>
{
	private int score;
	public int score() {return this.score;}
	
	private int modifier;
	public int modifier() {return modifier;}
	
	public void set_value(int score) {
		this.score = score;
		this.modifier = (int) Math.floor(score/2)-5;
	}
	
	public AbilityScoreGroup(AbilityScoreElement ability_score, int score) {
		this.element = ability_score;
		this.score = score;
		this.modifier = (int) (Math.floor(score/2)-5);;
	}
}
