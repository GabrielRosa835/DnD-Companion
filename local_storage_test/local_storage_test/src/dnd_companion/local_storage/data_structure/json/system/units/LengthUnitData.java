package src.data_structure.json.system.units;

import src.data_structure.json.atomic.LengthUnit;
import src.data_structure.json.templates.OptionData;

public record LengthUnitData(LengthUnit... options)
        implements OptionData<LengthUnit> {
    public LengthUnitData() {
        this(
                new LengthUnit("Meters", "M", 1),
                new LengthUnit("Centimeters", "CM", 100),
                new LengthUnit("Feet", "FT", 3.28084),
                new LengthUnit("Inch", "M", 39.3701),
                new LengthUnit("Squares", "S", 1.5)
        );
    }

    @Override
    public String collection() {
        return "units";
    }

    @Override
    public String file_name() {
        return "length-units";
    }
}
