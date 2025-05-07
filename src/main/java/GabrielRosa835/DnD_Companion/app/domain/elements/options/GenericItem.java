package app.domain.elements.options;

import app.domain.elements.components.MeasureComponent;
import app.domain.elements.models.types.Item;
import app.domain.elements.models.Option;

import java.util.*;

public record GenericItem(
		String ID,
		String name,
		MeasureComponent price,
		MeasureComponent weight,
		Set<ItemTag> tags,
		String description
) implements Option, Item {
}
