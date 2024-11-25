package dnd_companion.local_storage.system_components.class_maps;

import java.util.HashMap;
import java.util.Map;

import dnd_companion.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.local_storage.data.structure.options.DamageType;
import dnd_companion.local_storage.data.structure.options.DiceType;
import dnd_companion.local_storage.data.structure.options.ItemTag;

public final class OptionClassMap
{
	private static final Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
	public static final Map<String, Class<?>> mapping() {return mapping;}
	
	static {
		mapping.put(ArmorCategory.GROUP, ArmorCategory.class);
		mapping.put(DamageType.GROUP, DamageType.class);
		mapping.put(DiceType.GROUP, DiceType.class);
		mapping.put(ItemTag.GROUP, ItemTag.class);
    }
}
