package dnd_companion.local_storage.data.manipulation.archived.main;

import dnd_companion.local_storage.data.manipulation.archived.atomic.ability_score.AbilityScoreManager;
import dnd_companion.local_storage.data.manipulation.archived.atomic.saving_throw.SavingThrowManager;
import dnd_companion.local_storage.data.manipulation.archived.main.attributes.SkillManager;
import dnd_companion.local_storage.data.manipulation.archived.main.life.Life;
import dnd_companion.local_storage.data.manipulation.price.PriceManager;

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
