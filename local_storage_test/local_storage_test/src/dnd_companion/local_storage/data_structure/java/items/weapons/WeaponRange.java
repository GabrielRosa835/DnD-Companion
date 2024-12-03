package src.data_structure.java.items.weapons;

import src.data_structure.json.atomic.LengthUnit;
import src.data_structure.json.system.units.LengthUnitData;
import src.data_validation.DataValidator;
import src.system_components.DataKey;

public class WeaponRange {
    private double min_value;
    private double max_value;
    private LengthUnit unit;

    public double min_value() {
        return this.min_value;
    }

    public double max_value() {
        return this.max_value;
    }

    public LengthUnit unit() {
        return this.unit;
    }

    public WeaponRange(
            double min_value,
            double max_value,
            String unit
    ) {
        this.min_value = min_value;
        this.max_value = max_value;
        this.unit = validate_unit(unit);
    }

    private LengthUnit validate_unit(String unit) {
        return (LengthUnit) DataValidator.validate_unit(new DataKey(LengthUnitData.class), unit);
    }
}
