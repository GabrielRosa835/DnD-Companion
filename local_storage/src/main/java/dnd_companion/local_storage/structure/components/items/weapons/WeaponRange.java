package dnd_companion.local_storage.structure.components.items.weapons;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitDataOptions;
import dnd_companion.local_storage.validation.DataValidator;

public class WeaponRange
{
	private double min_value;
	private double max_value;
	private LengthUnitData unit;

	public double min_value() {return this.min_value;}
	public double max_value() {return this.max_value;}
	public LengthUnitData unit() {return this.unit;}

	public WeaponRange(
		double min_value,
		double max_value,
		String unit
	) {
		this.min_value = min_value;
		this.max_value = max_value;
		this.unit = validate_unit(unit);
	}

	private LengthUnitData validate_unit(String unit) {
		return (LengthUnitData) DataValidator.validate_unit(new DataKey(LengthUnitDataOptions.class), unit);
	}
}
