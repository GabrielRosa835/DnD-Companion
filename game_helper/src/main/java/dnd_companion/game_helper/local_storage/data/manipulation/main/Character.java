package dnd_companion.game_helper.local_storage.data.manipulation.main;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.ability_score.AbilityScoreManager;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.PriceManager;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.saving_throw.SavingThrowManager;
import dnd_companion.game_helper.local_storage.data.manipulation.main.attributes.SkillManager;
import dnd_companion.game_helper.local_storage.data.manipulation.main.life.Life;

public class Character {
	public int proficiency_bonus;
	public Life life;
	public AbilityScoreManager status;
	public SavingThrowManager saving_throws;
	public SkillManager skills;
	public PriceManager wealth;
	public String player;
	
	public Character() {
		this.proficiency_bonus = 0;
		this.life = null;
		this.skills = null;
		this.wealth = null;
		this.player = null;
	}
}
