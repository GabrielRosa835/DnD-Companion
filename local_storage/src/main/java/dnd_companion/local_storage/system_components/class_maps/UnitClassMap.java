package dnd_companion.local_storage.system_components.class_maps;

import java.util.HashMap;
import java.util.Map;

import dnd_companion.local_storage.data.structure.units.Currency;
import dnd_companion.local_storage.data.structure.units.LengthUnit;
import dnd_companion.local_storage.data.structure.units.WeightUnit;

public final class UnitClassMap
{
	private static final Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
	public static final Map<String, Class<?>> mapping() {return mapping;}
	
	static {
		mapping.put(Currency.GROUP, Currency.class);
		mapping.put(LengthUnit.GROUP, LengthUnit.class);
		mapping.put(WeightUnit.GROUP, WeightUnit.class);
    }
}
