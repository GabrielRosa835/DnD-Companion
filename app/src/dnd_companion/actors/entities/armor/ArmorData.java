package dnd_companion.actors.entities.armor;

import dnd_companion.actors.entities.armor.data.ChainMail;
import dnd_companion.actors.entities.armor.data.LeatherArmor;
import dnd_companion.actors.entities.armor.data.ScaleMail;
import dnd_companion.actors.entities.armor.data.Unarmored;
import dnd_companion.actors.models.IData;

public enum ArmorData implements IData
{
	CHAIN_MAIL(new ChainMail()), 
	LEATHER_ARMOR(new LeatherArmor()), 
	SCALE_MAIL(new ScaleMail()), 
	UNARMORED(new Unarmored());
	
	private ArmorEntity entity;
	private ArmorData(ArmorEntity entity) {
		this.entity = entity;
	}
	@Override public ArmorEntity use() {
		return entity.clone();
	}
}
