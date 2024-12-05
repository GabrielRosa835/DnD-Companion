package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.structure.data.atomic.LengthUnit;
import dnd_companion.local_storage.structure.data.templates.OptionData;

public record LengthUnitData (LengthUnit... options)
implements OptionData<LengthUnit>
{
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
	public String collection() {return "units";}
	@Override
	public String file_name() {return "length-units";}
}
