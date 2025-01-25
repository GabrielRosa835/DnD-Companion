package dnd_companion.entities.unit_related.length;

import dnd_companion.entities.addons.models.EntityBuilder;

public class LengthUnitBuilder implements EntityBuilder
{
	private String name = "No name";
	private String singular = "No singular option";
	private String abbreviation = "No abbreviation option";
	private double normalizing_factor = 0;

	LengthUnitBuilder() {}

	@Override public LengthUnitEntity build() {
		return new LengthUnitEntity(name, singular, abbreviation, normalizing_factor);
	}

	public LengthUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public LengthUnitBuilder singular(String singular) {
		this.singular = singular;
		return this;
	}
	public LengthUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public LengthUnitBuilder normalizing_factor(double normalizing_factor) {
		this.normalizing_factor = normalizing_factor;
		return this;
	}
}
