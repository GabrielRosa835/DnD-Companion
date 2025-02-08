package dnd_companion.actors.entities.system.unit.time;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.types.Unit;

public class TimeUnitEntity implements Entity, Unit
{
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	@Override public String name() {return name;}
	@Override public String singularForm() {return singularForm;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizingFactor() {return normalizingFactor;}

	TimeUnitEntity(String name, String singularForm, String abbreviation, double normalizingFactor) {
		this.name = name;
		this.singularForm = singularForm;
		this.abbreviation = abbreviation;
		this.normalizingFactor = normalizingFactor;
	}
	protected TimeUnitEntity(TimeUnitEntity entity) {
		this.name = entity.name;
		this.singularForm = entity.singularForm;
		this.abbreviation = entity.abbreviation;
		this.normalizingFactor = entity.normalizingFactor;
	}

	@Override public String toString() {
		return String.format("TimeUnit[name=%s, singularForm=%s, abbreviation=%s, normalizingFactor=%s]",
				name, singularForm, abbreviation, normalizingFactor);
	}
	@Override public TimeUnitEntity clone() {
		return new TimeUnitEntity(this);
	}
}
