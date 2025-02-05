package dnd_companion.actors.entities.system.unit.time;

import dnd_companion.actors.models.EntityBuilder;

public class TimeUnitBuilder implements EntityBuilder
{
	private String name = "Normal";
	private String singularForm = "Normal";
	private String abbreviation = "norm";
	private double normalizingFactor = 1;

	TimeUnitBuilder() {}

	@Override public TimeUnitEntity build() {
		return new TimeUnitEntity(name, singularForm, abbreviation, normalizingFactor);
	}

	public TimeUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public TimeUnitBuilder singularForm(String singularForm) {
		this.singularForm = singularForm;
		return this;
	}
	public TimeUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public TimeUnitBuilder normalizingFactor(double normalizingFactor) {
		this.normalizingFactor = normalizingFactor;
		return this;
	}
}
