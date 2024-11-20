package dnd_companion.game_helper.local_storage.data_structure.archived.atomic.damage;

import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.Convertible;
import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.Group;
import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.dice.DiceManager;

public class DamageGroup extends Group<Damage> implements Convertible<Damage, DamageGroup>
{
	private DiceManager dices;
	public DiceManager dices() {return this.dices;}

	public DamageGroup(Damage damage, DiceManager dices) {
		this.element = damage;
		this.dices = dices;
	}
	
	@Override 
	public void convert_to(Damage damage) {
		this.element = damage;
	}
	
	@Override 
	public DamageGroup convert_new(Damage damage) {
		return new DamageGroup(damage, this.dices);
	}
}
