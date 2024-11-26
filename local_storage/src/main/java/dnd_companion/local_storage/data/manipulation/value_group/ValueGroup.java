package dnd_companion.local_storage.data.manipulation.value_group;

import java.util.Arrays;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.DataKey;

public abstract class ValueGroup<T extends AtomicUnit>
{
	private double value;
	public double value() {return this.value;}
	
	protected T unit;
	public T unit(){return this.unit;}
	
	protected abstract String unit_collection();
	protected abstract String unit_name();
	
	public ValueGroup(double value, String unit) {
		this.value = value;
		this.unit = validate_unit(null);
	}

	public ValueGroup<T> convert_to(String unit) {
		T validated_unit = validate_unit(unit);
		this.value = this.value * (this.unit.normalizing_factor() / validated_unit.normalizing_factor());
		this.unit = validated_unit;
		return this;
	}
	
	private T validate_unit(String unit) {
		DataKey key = new DataKey(this.unit_collection(), this.unit_name(), this.unit().getClass().getName());
		T[] options = DataHandler.retrieve_options(key);
		return Arrays.stream(options)
				.filter(option -> option.name().equals(unit) || option.abbreviation().equals(unit))
				.findFirst().get();
	}
}
