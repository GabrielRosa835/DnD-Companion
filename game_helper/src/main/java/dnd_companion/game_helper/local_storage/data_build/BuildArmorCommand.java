package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;
import dnd_companion.game_helper.local_storage.data.structure.ArmorData;

public class BuildArmorCommand extends DataBuilderCommand 
{
	private String name;
	private String collection;
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
		String collection, 
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
		this.collection = collection;
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
			ArmorData data = new ArmorData(
				this.name,
				this.collection,
				(Price) this.price.convert_to("normal"),
				(Weight) this.weight.convert_to("normal"),
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
			this.status = false;
		}
		return this;
	}
}
















