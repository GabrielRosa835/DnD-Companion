package dnd_companion.actors.entities.system.unit.weight;

import dnd_companion.actors.models.IEntityBuilder;

public class WeightUnitBuilder implements IEntityBuilder
{
	private String name = "Normal";
	private String singularForm = "Normal";
	private String abbreviation = "norm";
	private double normalizingFactor = 1;

	WeightUnitBuilder() {}

	@Override public WeightUnitEntity build() {
		return new WeightUnitEntity(name, singularForm, abbreviation, normalizingFactor);
	}

	public WeightUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public WeightUnitBuilder singularForm(String singularForm) {
		this.singularForm = singularForm;
		return this;
	}
	public WeightUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public WeightUnitBuilder normalizingFactor(double normalizingFactor) {
		this.normalizingFactor = normalizingFactor;
		return this;
	}
}
