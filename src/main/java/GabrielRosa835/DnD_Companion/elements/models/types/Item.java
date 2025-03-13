package elements.models.types;

import elements.components.*;
import elements.entities.options.*;

import java.util.*;

public interface Item {
	String name();
	Measure price();
	Measure weight();
	ItemTag[] tags();
	String description();
}