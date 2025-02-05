package dnd_companion.actors.entities.system.unit.length;

import dnd_companion.actors.models.EntityBuilder;

public class LengthUnitBuilder implements EntityBuilder
{
	private String name = "Normal";
	private String singularForm = "Normal";
	private String abbreviation = "norm";
	private double normalizingFactor = 1;

	LengthUnitBuilder() {}

	@Override public LengthUnitEntity build() {
		return new LengthUnitEntity(name, singularForm, abbreviation, normalizingFactor);
	}

	public LengthUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public LengthUnitBuilder singularForm(String singularForm) {
		this.singularForm = singularForm;
		return this;
	}
	public LengthUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public LengthUnitBuilder normalizingFactor(double normalizingFactor) {
		this.normalizingFactor = normalizingFactor;
		return this;
	}
}
