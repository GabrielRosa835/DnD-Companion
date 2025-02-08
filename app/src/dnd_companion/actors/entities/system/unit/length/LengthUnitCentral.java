package dnd_companion.actors.entities.system.unit.length;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.system.unit.length.data.Centimeters;
import dnd_companion.actors.entities.system.unit.length.data.Feet;
import dnd_companion.actors.entities.system.unit.length.data.Inches;
import dnd_companion.actors.entities.system.unit.length.data.Squares;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class LengthUnitCentral implements EntityCentral
{
	private static LengthUnitCentral instance;
	private LengthUnitCentral() {}
	public static LengthUnitCentral use() {
		return instance == null? new LengthUnitCentral() : instance;
	}
	
	@Override public LengthUnitBuilder builder() {
		return new LengthUnitBuilder();
	}
	@Override public LengthUnitScheme scheme() {
		return new LengthUnitScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.LENGTH_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public LengthUnitEntity retrieve(String entity_name) {
		return (LengthUnitEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public Entity[] data() {
		return Arrays.asList(
				new Centimeters(),
				new Feet(),
				new Inches(),
				new Squares())
				.toArray(LengthUnitEntity[]::new);
	}
}
