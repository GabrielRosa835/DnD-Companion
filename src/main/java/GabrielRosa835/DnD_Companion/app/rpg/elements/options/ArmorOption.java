package app.rpg.elements.options;

import app.rpg.elements.components.MeasureComponent;
import app.rpg.models.Option;
import app.rpg.elements.options.types.Item;
import lombok.Builder;

@Builder (setterPrefix = "with")
public record ArmorOption(
		ItemTagOption[] tags,
		String description,
		MeasureComponent weight,
		MeasureComponent price,
		String name,

		ArmorCategoryOption category,
		boolean stealthDisadvantage,
		int strengthRequirement,
		int baseArmorClass
) implements Option, Item
{
	//
}