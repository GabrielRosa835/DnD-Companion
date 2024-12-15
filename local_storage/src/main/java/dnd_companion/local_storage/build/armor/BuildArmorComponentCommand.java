package dnd_companion.local_storage.build.armor;

import java.util.Arrays;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.structure.components.items.armors.ArmorCategoryComponent;
import dnd_companion.local_storage.structure.components.items.armors.ArmorComponent;
import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class BuildArmorComponentCommand extends Command<ArmorComponent>
{
	private ArmorData data;
	
	public BuildArmorComponentCommand(ArmorData data) {
		this.data = data;
	}

	public BuildArmorComponentCommand execute() {
		this.result = new ArmorComponent(
				data.name(),
				new Price(data.price_value(), data.price_unit()),
				new Weight(data.weight_value(), data.weight_unit()),
				Arrays.stream(data.tags()).map(t -> new ItemTagComponent(t)).toArray(ItemTagComponent[]::new),
				data.description(),
				new ArmorCategoryComponent(data.category()),
				data.armor_class(),
				data.strength_requirement(),
				data.stealth_disadvantage());
	}
}
