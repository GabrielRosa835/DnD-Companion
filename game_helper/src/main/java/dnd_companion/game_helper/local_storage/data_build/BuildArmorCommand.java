package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;
import dnd_companion.game_helper.local_storage.data.structure.ArmorData;
import dnd_companion.game_helper.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.game_helper.local_storage.data_validation.DataValidator;
import dnd_companion.game_helper.utils.ToolBox;

public class BuildArmorCommand extends DataBuilderCommand 
{
	private String name;
	private Price price;
	private Weight weight;
	private String[] tags;
	private String description;
	private ArmorCategory category;
	private int base_armor_class;
	private int strength_requirement;
	private boolean stealth_disavantage;
	
	public BuildArmorCommand(
		String name, 
		Price price,
		Weight weight,
		String[] tags, 
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
			ArmorCategory validated_category = (ArmorCategory) DataValidator.validate_option(category);
			Price validated_price = (Price) DataValidator.validate_group_value(price);
			Weight validated_weight = (Weight) DataValidator.validate_group_value(weight);
			
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
















