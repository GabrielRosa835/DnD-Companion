package dnd_companion.local_storage.data.manipulation.archived.atomic.damage;

import dnd_companion.local_storage.data.manipulation.archived.atomic.Convertible;
import dnd_companion.local_storage.data.manipulation.archived.atomic.dice.DiceManager;
import dnd_companion.local_storage.data.manipulation.archived.atomic.templates.Group;

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
