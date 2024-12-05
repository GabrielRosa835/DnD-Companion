package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.structure.data.atomic.WeightUnit;
import dnd_companion.local_storage.structure.data.templates.OptionData;

public record WeightUnitData (WeightUnit... options)
implements OptionData<WeightUnit>
{
	public WeightUnitData() {
		this(
			new WeightUnit("Kilograms", "KG", 1),
			new WeightUnit("Pounds", "LBS", 2.20462),
			new WeightUnit("Grams", "G", 1000),
			new WeightUnit("Ounces", "OZ", 35.274)
		);
	}

	@Override
	public String collection() {return "units";}
	@Override
	public String file_name() {return "weight-units";}
}
