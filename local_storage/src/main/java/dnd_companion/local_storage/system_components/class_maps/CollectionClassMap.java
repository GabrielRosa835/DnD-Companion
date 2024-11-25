package dnd_companion.local_storage.system_components.class_maps;

import java.util.*;

import dnd_companion.local_storage.data.structure.ArmorData;
import dnd_companion.local_storage.data.structure.OptionData;
import dnd_companion.local_storage.data.structure.UnitData;

public final class CollectionClassMap
{
	private static final Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
	public static final Map<String, Class<?>> mapping() {return mapping;}
	
	static {
		mapping.put(ArmorData.COLLECTION, ArmorData.class);
        mapping.put(OptionData.COLLECTION, OptionData.class);
        mapping.put(UnitData.COLLECTION, UnitData.class);
        // CAMPAIGNS
        // CHARACTERS
        // MONSTERS
        // WEAPONS
        // ITEMS
    }
}
