package dnd_companion.local_storage.build.armor;

import dnd_companion.local_storage.build.DataBuilderCommand;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;
import dnd_companion.local_storage.structure.data.items.tags.ItemTagData;
import dnd_companion.local_storage.validation.DataValidator;

public class BuildArmorDataCommand extends DataBuilderCommand<ArmorData>
{
	private String name;
	private Price price;
	private Weight weight;
	private String[] tags;
	private String description;
	private String category;
	private int base_armor_class;
	private int strength_requirement;
	private boolean stealth_disavantage;

	public BuildArmorDataCommand(
		String name,
		Price price,
		Weight weight,
		String[] tags,
		String description,
		String category,
		int base_armor_class,
		int strength_requirement,
		boolean stealth_disavantage
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
		this.category = category;
		this.base_armor_class = base_armor_class;
		this.strength_requirement = strength_requirement;
		this.stealth_disavantage = stealth_disavantage;
	}

	@Override
	public BuildArmorDataCommand execute()
	{
		try {
			DataValidator.validate_option(new DataKey(ArmorCategoryData.class), category);
			DataValidator.validate_options(new DataKey(ItemTagData.class), tags);

			ArmorData data = new ArmorData(
				this.name,
				this.price.value(),
				this.price.unit().abbreviation(),
				this.weight.value(),
				this.weight.unit().abbreviation(),
				this.tags,
				this.description,
				this.category,
				this.base_armor_class,
				this.strength_requirement,
				this.stealth_disavantage
			);

			this.result = data;
			this.status = true;
			this.message = "Armor data successfully created (" + data.name() + ")";
		} catch (Exception e) {
			this.result = null;
			this.status = false;
			this.message = "A problem ocurred while trying to create armor data (" + this.name + ")";
			ToolBox.print_err(e);
		}
		return this;
	}
}
















