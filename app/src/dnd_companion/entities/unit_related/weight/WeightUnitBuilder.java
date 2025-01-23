package dnd_companion.entities.unit_related.weight;

import dnd_companion.entities.addons.models.EntityBuilder;

public class WeightUnitBuilder implements EntityBuilder
{
	private String name = "No name";
	private String plural = "No plural option";
	private String abbreviation = "No abbreviation option";
	private double normalizing_factor = 0;
	
	WeightUnitBuilder() {}
	
	@Override public WeightUnitEntity build() {
		return new WeightUnitEntity(name, plural, abbreviation, normalizing_factor);
	}
	
	public WeightUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public WeightUnitBuilder plural(String plural) {
		this.plural = plural;
		return this;
	}
	public WeightUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public WeightUnitBuilder normalizing_factor(double normalizing_factor) {
		this.normalizing_factor = normalizing_factor;
		return this;
	}
}
