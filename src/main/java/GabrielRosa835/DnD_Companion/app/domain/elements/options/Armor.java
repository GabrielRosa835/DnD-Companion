package app.domain.elements.options;

import app.domain.elements.components.*;
import app.domain.elements.models.*;
import app.domain.elements.models.types.*;
import lombok.*;

import java.util.*;

@With
public record Armor(
		String ID,
		String name,
		Set<ItemTag> tags,
		String description,
		MeasureComponent weight,
		MeasureComponent price,

		ArmorCategory category,
		boolean stealthDisadvantage,
		int strengthRequirement,
		int baseArmorClass
) implements Option, Item {
	//
}