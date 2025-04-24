package app.rpg.elements.models.types;

import app.rpg.elements.options.ItemTagOption;
import app.rpg.elements.components.MeasureComponent;

public interface Item {
	MeasureComponent price();

	MeasureComponent weight();

	ItemTagOption[] tags();

	String description();
}