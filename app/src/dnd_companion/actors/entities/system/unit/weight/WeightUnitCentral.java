package dnd_companion.actors.entities.system.unit.weight;

import java.io.File;
import java.util.Arrays;

import dnd_companion.actors.entities.system.unit.weight.data.Grams;
import dnd_companion.actors.entities.system.unit.weight.data.Kilograms;
import dnd_companion.actors.entities.system.unit.weight.data.Ounces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.storage.handling.DataHandler;

public class WeightUnitCentral implements IEntityCentral
{
	private static WeightUnitCentral instance;
	private WeightUnitCentral() {}
	public static WeightUnitCentral use() {
		if (instance == null) {
			return new WeightUnitCentral();
		} else {
			return instance;
		}
	}
	
	@Override public WeightUnitBuilder builder() {
		return new WeightUnitBuilder();
	}
	@Override public WeightUnitScheme scheme() {
		return new WeightUnitScheme();
	}
	@Override public BaseCollections collection() {
		return BaseCollections.WEIGHT_UNITS;
	}
	@Override public String path(String entity_name) {
		return collection().path() + File.separator + ToolBox.toFileName(entity_name);
	}
	@Override public WeightUnitEntity retrieve(String entity_name) {
		return (WeightUnitEntity) DataHandler.retrieve(this, entity_name);
	}
	@Override public WeightUnitEntity[] data() {
		return Arrays.asList(
				new Grams(),
				new Kilograms(),
				new Ounces(),
				new Pounds())
				.toArray(WeightUnitEntity[]::new);
	}
}
