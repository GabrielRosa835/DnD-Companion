package main;

import atomic.ability_score.AbilityScoreManager;
import atomic.currency.CurrencyManager;
import atomic.saving_throw.SavingThrowManager;
import main.attributes.SkillManager;
import main.life.Life;

public class Character {
	public int proficiency_bonus;
	public Life life;
	public AbilityScoreManager status;
	public SavingThrowManager saving_throws;
	public SkillManager skills;
	public CurrencyManager wealth;
	public String player;
	
	public Character() {
		this.proficiency_bonus = 0;
		this.life = null;
		this.skills = null;
		this.wealth = null;
		this.player = null;
	}
}
