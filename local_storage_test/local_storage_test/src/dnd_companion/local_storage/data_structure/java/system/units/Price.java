package src.data_structure.java.system.units;

import src.data_structure.java.templates.UnitGroup;
import src.data_structure.json.atomic.CurrencyUnit;
import src.data_structure.json.system.units.CurrencyUnitData;
import src.system_components.DataKey;

public class Price extends UnitGroup<CurrencyUnit> {
    @Override
    public DataKey unit_key() {
        return new DataKey(CurrencyUnitData.class);
    }

    public Price() {
        super(0, "GP");
    }

    public Price(double value, String unit) {
        super(value, unit);
    }
}
