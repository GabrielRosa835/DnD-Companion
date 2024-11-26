package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.manipulation.value_group.Price;
import dnd_companion.local_storage.data.manipulation.value_group.Weight;
import dnd_companion.local_storage.data.structure.items.ItemTagData;
import dnd_companion.local_storage.data.structure.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.data.structure.items.armors.ArmorData;
import dnd_companion.local_storage.data.structure.system.units.CurrencyData;
import dnd_companion.local_storage.data.structure.system.units.WeightUnitData;
import dnd_companion.local_storage.data_validation.DataValidator;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class BuildArmorCommand extends DataBuilderCommand 
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
	
	public BuildArmorCommand(
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

	public BuildArmorCommand execute() 
	{
		try {
			ToolBox.print("Reached here: %s", BuildArmorCommand.class.getName());
			DataValidator.validate_option(
					new DataKey(
							new ArmorCategoryData().collection(), 
							new ArmorCategoryData().name(), 
							new ArmorCategoryData().getClass().getName()
							), this.category);
			DataValidator.validate_option(
					new DataKey(
							new CurrencyData().collection(), 
							new CurrencyData().name(), 
							new CurrencyData().getClass().getName()
							), this.price.unit());
			DataValidator.validate_option(
					new DataKey(
							new WeightUnitData().collection(), 
							new WeightUnitData().name(), 
							new WeightUnitData().getClass().getName()
							), this.weight.unit());
			DataValidator.validate_options(
					new DataKey(
							new ItemTagData().collection(), 
							new ItemTagData().name(), 
							new ItemTagData().getClass().getName()
							), this.tags);
			
			ArmorData data = new ArmorData(
				this.name,
				(Price) price.convert_to("Normal"),
				(Weight) weight.convert_to("Normal"),
				this.tags,
				this.description,
				this.category,
				this.base_armor_class,
				this.strength_requirement,
				this.stealth_disavantage
			);
			
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
















