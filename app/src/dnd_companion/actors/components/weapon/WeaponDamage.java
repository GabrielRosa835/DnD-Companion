package dnd_companion.actors.components.weapon;

import dnd_companion.actors.components.rules.Dice;
import dnd_companion.actors.entities.rules.damage_types.DamageTypeEntity;
import dnd_companion.actors.models.Component;
import dnd_companion.effects.Effect;
import dnd_companion.effects.Effectable;

public class WeaponDamage implements Component, Effectable
{
	private int diceAmmount;
	private Dice dice;
	private DamageTypeEntity type;
	private Dice versatileDice;
	
	public int diceAmmount() {return diceAmmount;}
	public Dice dice() {return dice;}
	public DamageTypeEntity type() {return type;}
	public Dice versatileDice() {return versatileDice;}

	public WeaponDamage(int diceAmmount, Dice dice, DamageTypeEntity type, Dice versatileDice) {
		this.diceAmmount = diceAmmount;
		this.dice = dice;
		this.type = type;
		this.versatileDice = versatileDice;
	}
	private WeaponDamage(WeaponDamage clone) {
		this.diceAmmount = clone.diceAmmount;
		this.dice = clone.dice.clone();
		this.type = type.clone();
		this.versatileDice = clone.versatileDice.clone();
	}
	
	@Override public WeaponDamage clone() {
		return new WeaponDamage(this);
	}
	@Override public WeaponDamage applyEffect(Effect effect) {
		InterEffect e = (InterEffect) effect;
		e.loadObject(this);
		this.diceAmmount = e.changeDiceAmmount();
		this.dice = e.changeDice();
		this.type = e.changeDamageType();
		this.versatileDice = e.changeVersatileDice();
		return this;
	}
	
	public interface InterEffect extends Effect {
		public int changeDiceAmmount();
		public Dice changeDice();
		public DamageTypeEntity changeDamageType();
		public Dice changeVersatileDice();
	}
}
