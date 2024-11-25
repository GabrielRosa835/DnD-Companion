package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.manipulation.ItemTags;
import dnd_companion.local_storage.data.manipulation.price.Price;
import dnd_companion.local_storage.data.manipulation.weight.Weight;
import dnd_companion.local_storage.data.structure.ArmorData;
import dnd_companion.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.local_storage.data_validation.DataValidator;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class BuildArmorCommand extends DataBuilderCommand 
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTags tags;
	private String description;
	private ArmorCategory category;
	private int base_armor_class;
	private int strength_requirement;
	private boolean stealth_disavantage;
	
	public BuildArmorCommand(
		String name, 
		Price price,
		Weight weight,
		ItemTags tags, 
		String description, 
		ArmorCategory category, 
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
			ArmorCategory validated_category = (ArmorCategory) DataValidator.validate_options(category)[0];
			Price validated_price = (Price) DataValidator.validate_value_groups(price)[0];
			Weight validated_weight = (Weight) DataValidator.validate_value_groups(weight)[0];
			
			ArmorData data = new ArmorData(
				this.name,
				(Price) validated_price.convert_to("Normal"),
				(Weight) validated_weight.convert_to("Normal"),
				this.tags,
				this.description,
				validated_category,
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
















