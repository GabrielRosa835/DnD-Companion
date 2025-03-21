package GabrielRosa835.dnd_companion.app.elements.models;

import GabrielRosa835.dnd_companion.app.elements.entities.items.*;
import GabrielRosa835.dnd_companion.app.elements.entities.system.*;

public interface Item {
	String name();
	Measure price();
	Measure weight();
	ItemTag[] tags();
	String description();
}