package app.domain.elements.options;

import app.domain.elements.components.*;
import app.domain.elements.models.Option;
import app.domain.elements.models.types.*;

import java.util.*;

public record AmmunitionType(
		String ID,
		String name,
		String description,
		MeasureComponent price,
		MeasureComponent weight,
		Set<ItemTag> tags,
		List<Weapon> allowedWeapons
) implements Option, Item {

}
