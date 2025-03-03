package dnd_companion.storage.assembling;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.entities.armor.ArmorCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.rules.condition.ConditionCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.models.IData;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.design_patterns.Command;

public class SetupStorageCommand implements Command
{
	private List<IEntityCentral> centralList = Arrays.asList(
			ArmorCentral.use(),
			ArmorCategoryCentral.use(),
			ItemTagCentral.use(),
			ConditionCentral.use(),
			CurrencyUnitCentral.use(),
			LengthUnitCentral.use(),
			TimeUnitCentral.use(),
			WeightUnitCentral.use()
			);

	public void execute() {
		StorageAssembler.clearData();

		for (BaseCollections collection : BaseCollections.mapping().keySet()) {
			StorageAssembler.createDirectory(collection.path());
		}

		for (IEntityCentral central : centralList) {
			IData[] entities = central.data();
			DataHandler.save(central, entities);
		}
	}
}
