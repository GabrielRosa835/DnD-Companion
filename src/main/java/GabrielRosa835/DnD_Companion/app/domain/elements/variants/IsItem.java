package app.domain.elements.variants;

import app.domain.elements.entities.options.items.*;
import app.experimental.*;

import java.util.*;

public interface IsItem {
	String name();
	String description();
	MeasureComponent price();
	MeasureComponent weight();
	Map<String, ItemTag> tags();
}