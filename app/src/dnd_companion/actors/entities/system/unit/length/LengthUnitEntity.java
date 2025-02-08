package dnd_companion.actors.entities.system.unit.length;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.types.Unit;

public class LengthUnitEntity implements Entity, Unit
{
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	@Override public String name() {return name;}
	@Override public String singularForm() {return singularForm;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizingFactor() {return normalizingFactor;}

	LengthUnitEntity(String name, String singularForm, String abbreviation, double normalizingFactor) {
		this.name = name;
		this.singularForm = singularForm;
		this.abbreviation = abbreviation;
		this.normalizingFactor = normalizingFactor;
	}
	protected LengthUnitEntity(LengthUnitEntity entity) {
		this.name = entity.name;
		this.singularForm = entity.singularForm;
		this.abbreviation = entity.abbreviation;
		this.normalizingFactor = entity.normalizingFactor;
	}

	@Override public String toString() {
		return String.format("LengthUnit[name=%s, singularForm=%s, abbreviation=%s, normalizingFactor=%s]",
				name, singularForm, abbreviation, normalizingFactor);
	}
	@Override public LengthUnitEntity clone() {
		return new LengthUnitEntity(this);
	}
}
