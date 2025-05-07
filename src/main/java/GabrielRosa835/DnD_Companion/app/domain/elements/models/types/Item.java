package app.domain.elements.models.types;

import app.domain.elements.options.ItemTag;
import app.domain.elements.components.MeasureComponent;

import java.util.*;

public interface Item {
	MeasureComponent price();

	MeasureComponent weight();

	Set<ItemTag> tags();

	String description();
}