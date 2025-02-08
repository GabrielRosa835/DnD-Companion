package dnd_companion.actors.entities.armor;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.armor.data.ChainMail;
import dnd_companion.actors.entities.armor.data.LeatherArmor;
import dnd_companion.actors.entities.armor.data.ScaleMail;
import dnd_companion.actors.entities.armor.data.Unarmored;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class ArmorCentral implements EntityCentral
{
	private static ArmorCentral instance;
	private ArmorCentral() {}
	public static ArmorCentral use() {
		return instance == null? new ArmorCentral() : instance;
	}
	
	@Override public ArmorBuilder builder() {
		return new ArmorBuilder();
	}
	@Override public ArmorScheme scheme() {
		return new ArmorScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.ARMORS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public ArmorEntity retrieve(String entity_name) {
		return (ArmorEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public ArmorEntity[] data() {
		return Arrays.asList(
				new ChainMail(),
				new LeatherArmor(),
				new ScaleMail(),
				new Unarmored())
				.toArray(ArmorEntity[]::new);
	}
}
