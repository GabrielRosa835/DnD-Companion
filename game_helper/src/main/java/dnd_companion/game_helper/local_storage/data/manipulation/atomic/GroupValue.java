package dnd_companion.game_helper.local_storage.data.manipulation.atomic;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_validation.DataValidator;

public abstract class GroupValue
{
	private double value;
	public double value() {return this.value;}
	
	private AtomicOptionUnit unit;
	public AtomicOptionUnit unit() {return this.unit;}
	
	protected abstract AtomicOptionUnit[] unit_options();
	public abstract String unit_group();
	
	public GroupValue(double value, String unit) {
		this.value = value;
		this.unit = this.validate_unit(unit);
	}

	public GroupValue convert_to(String unit) {
		AtomicOptionUnit validated_unit = this.validate_unit(unit);
		this.unit = validated_unit;
		this.value = this.normalized_value() / validated_unit.normalizing_factor();
		return this;
	}

	public double normalized_value() {
		return this.value * this.unit.normalizing_factor();
	}
	
	protected AtomicOptionUnit validate_unit(String unit) {
		return DataValidator.validate_unit(unit, this.unit_group());
    }
}
