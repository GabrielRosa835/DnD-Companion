package dnd_companion.local_storage.archived.components.main;

import dnd_companion.local_storage.archived.components.atomic.ability_score.AbilityScoreManager;
import dnd_companion.local_storage.archived.components.atomic.saving_throw.SavingThrowManager;
import dnd_companion.local_storage.archived.components.main.attributes.SkillManager;
import dnd_companion.local_storage.archived.components.main.life.Life;
import dnd_companion.local_storage.structure.components.price.PriceManager;

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
