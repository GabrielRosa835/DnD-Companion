package dnd_companion.entities.armor_related.armor;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.armor_related.armor.data.ChainMail;
import dnd_companion.entities.armor_related.armor.data.DefaultArmor;
import dnd_companion.entities.armor_related.armor.data.LeatherArmor;
import dnd_companion.entities.armor_related.armor.data.ScaleMail;
import dnd_companion.entities.armor_related.armor.data.Unarmored;

public class ArmorFactory implements EntityFactory
{
	ArmorFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(unarmored(), leather_armor(), scale_mail(), chain_mail());
	}
	@Override public Entity defaultData() {
		return new DefaultArmor();
	}

	public ArmorEntity unarmored() {
		return new Unarmored();
	}
	public ArmorEntity leather_armor() {
		return new LeatherArmor();
	}
	public ArmorEntity scale_mail() {
		return new ScaleMail();
	}
	public ArmorEntity chain_mail() {
		return new ChainMail();
	}
}
