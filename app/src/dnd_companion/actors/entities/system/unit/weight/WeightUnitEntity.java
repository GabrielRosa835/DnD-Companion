package dnd_companion.actors.entities.system.unit.weight;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.types.Unit;
import dnd_companion.effects.IEffect;

public class WeightUnitEntity implements IEntity, Unit
{
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	@Override public String name() {return name;}
	@Override public String singularForm() {return singularForm;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizingFactor() {return normalizingFactor;}

	WeightUnitEntity(String name, String singularForm, String abbreviation, double normalizingFactor) {
		this.name = name;
		this.singularForm = singularForm;
		this.abbreviation = abbreviation;
		this.normalizingFactor = normalizingFactor;
	}
	protected WeightUnitEntity(WeightUnitEntity entity) {
		this(entity.name, entity.singularForm, entity.abbreviation, entity.normalizingFactor);
	}

	@Override public WeightUnitEntity clone() {
		return new WeightUnitEntity(this);
	}
	@Override public String toString() {
		return String.format("WeightUnit[name=%s, singularForm=%s, abbreviation=%s, normalizingFactor=%s]",
				name, singularForm, abbreviation, normalizingFactor);
	}
	
	public interface InterEffect extends IEffect {
		public String changeName();
		public String changeSingularForm();
		public String changeAbbreviation();
		public double changeNormalizingFactor();
	}
}
