package elements.models;

import elements.entities.items.ItemTag;
import elements.entities.system.Measure;

public interface Item {
	String name();
	Measure price();
	Measure weight();
	ItemTag[] tags();
	String description();
}