package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor.ArmorEntity;

public class DefaultArmor extends ArmorEntity
{
	public DefaultArmor() {
		super(new ArmorCentral().builder().build());
	}
}
