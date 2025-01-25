package dnd_companion.storage.assembling;

import java.util.Arrays;
import java.util.List;

import dnd_companion.common.design_patterns.Command;
import dnd_companion.common.metadata.Collections;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityCentral;
import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.rule_related.condition.ConditionCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.storage.handling.DataHandler;

public class SetupStorageCommand implements Command
{
	private List<EntityCentral> centralList = Arrays.asList(
			new ArmorCentral(),
			new ArmorCategoryCentral(),
			new ItemTagCentral(),
			new ConditionCentral(),
			new	CurrencyUnitCentral(),
			new LengthUnitCentral(),
			new TimeUnitCentral(),
			new WeightUnitCentral()
			);

	public void execute() {
		StorageAssembler.clearData();

		for (Collections collection : Collections.mapping().keySet()) {
			StorageAssembler.createDirectory(collection.path());
		}

		for (EntityCentral central : centralList) {
			List<Entity> entityList = central.factory().dataList();
			DataHandler.save(central, entityList.toArray(Entity[]::new));
		}
	}
}
