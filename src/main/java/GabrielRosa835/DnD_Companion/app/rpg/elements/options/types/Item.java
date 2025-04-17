package app.rpg.elements.options.types;

import app.rpg.elements.options.ItemTagOption;
import app.rpg.elements.components.MeasureComponent;
import app.rpg.models.IEntity;

public interface Item
{
	MeasureComponent price();
	MeasureComponent weight();
	ItemTagOption[] tags();
	String description();
}