package dnd_companion.local_storage.data_structure.java.templates;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.local_storage.data_structure.json.templates.AtomicUnit;
import dnd_companion.local_storage.data_validation.DataValidator;
import dnd_companion.local_storage.system_components.DataKey;

public abstract class UnitGroup<T extends AtomicUnit>
{
	@JsonProperty
	private double value;
	public double value() {return this.value;}

	@JsonProperty
	protected T unit;
	public T unit(){return this.unit;}

	protected abstract DataKey unit_key();

	public UnitGroup(double value, String unit) {
		this.value = value;
		this.unit = validate_unit(unit);
	}

	public UnitGroup<T> convert_to(String unit) {
		T validated_unit = validate_unit(unit);
		this.value = this.value * (this.unit.normalizing_factor() / validated_unit.normalizing_factor());
		this.unit = validated_unit;
		return this;
	}

	private T validate_unit(String unit) {
		return DataValidator.validate_unit(this.unit_key().clone(), unit);
	}
}
