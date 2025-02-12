package dnd_companion.actors.entities.system.unit.currency;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.types.Unit;
import dnd_companion.effects.IEffect;

public class CurrencyUnitEntity implements IEntity, Unit
{
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	@Override public String name() {return name;}
	@Override public String singularForm() {return singularForm;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizingFactor() {return normalizingFactor;}

	CurrencyUnitEntity(String name, String singularForm, String abbreviation, double normalizingFactor) {
		this.name = name;
		this.singularForm = singularForm;
		this.abbreviation = abbreviation;
		this.normalizingFactor = normalizingFactor;
	}
	protected CurrencyUnitEntity(CurrencyUnitEntity entity) {
		this(entity.name, entity.singularForm, entity.abbreviation, entity.normalizingFactor);
	}

	@Override public CurrencyUnitEntity clone() {
		return new CurrencyUnitEntity(this);
	}
	@Override public String toString() {
		return String.format("CurrencyUnit[name=%s, singularForm=%s, abbreviation=%s, normalizingFactor=%s]",
				name, singularForm, abbreviation, normalizingFactor);
	}
	
	public interface InterEffect extends IEffect {
		public String changeName();
		public String changeSingularForm();
		public String changeAbbreviation();
		public double changeNormalizingFactor();
	}
}
