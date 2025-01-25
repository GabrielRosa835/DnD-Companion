package dnd_companion.entities.unit_related.time;

import dnd_companion.entities.addons.models.EntityBuilder;

public class TimeUnitBuilder implements EntityBuilder
{
	private String name = "No name";
	private String singular = "No singular option";
	private String abbreviation = "No abbreviation option";
	private double normalizing_factor = 0;

	TimeUnitBuilder() {}

	@Override public TimeUnitEntity build() {
		return new TimeUnitEntity(name, singular, abbreviation, normalizing_factor);
	}

	public TimeUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public TimeUnitBuilder singular(String singular) {
		this.singular = singular;
		return this;
	}
	public TimeUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public TimeUnitBuilder normalizing_factor(double normalizing_factor) {
		this.normalizing_factor = normalizing_factor;
		return this;
	}
}
