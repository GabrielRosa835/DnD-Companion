package dnd_companion.entities.armor_related.armor;

import dnd_companion.entities.armor_related.armor.data.*;
import dnd_companion.entities.models.EntityFactory;

public class ArmorFactory implements EntityFactory
{
	public Unarmored unarmored() {
		return new Unarmored();
	}
	public LeatherArmor leather_armor() {
		return new LeatherArmor();
	}
	public ScaleMail scale_mail() {
		return new ScaleMail();
	}
	public ChainMail chain_mail() {
		return new ChainMail();
	}
}
