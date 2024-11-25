package dnd_companion.local_storage.data.manipulation;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data_validation.DataValidator;

public abstract class ValueGroup
{
	private double value;
	public double value() {return this.value;}
	
	protected AtomicUnit unit;
	public abstract AtomicUnit unit();
	
	protected abstract AtomicUnit[] unit_options();
	public abstract String unit_group();
	
	public ValueGroup(double value, String unit) {
		this.value = value;
		this.unit = this.validate_unit(unit);
	}

	public ValueGroup convert_to(String unit) {
		AtomicUnit validated_unit = this.validate_unit(unit);
		this.unit = validated_unit;
		this.value = this.normalized_value() / validated_unit.normalizing_factor();
		return this;
	}

	public double normalized_value() {
		return this.value * this.unit.normalizing_factor();
	}
	
	protected AtomicUnit validate_unit(String unit) {
		return DataValidator.validate_units(this.unit_group(), unit)[0];
    }
}
