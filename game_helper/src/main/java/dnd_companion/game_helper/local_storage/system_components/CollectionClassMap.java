package dnd_companion.game_helper.local_storage.system_components;

import java.util.*;

import dnd_companion.game_helper.local_storage.data.structure.ArmorData;
import dnd_companion.game_helper.local_storage.data.structure.OptionData;

public final class CollectionClassMap
{
	private static final Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
	public static final Map<String, Class<?>> mapping() {return mapping;}
	
	static {
		mapping.put(ArmorData.COLLECTION, ArmorData.class);
        mapping.put(OptionData.COLLECTION, OptionData.class);
        // CAMPAIGNS
        // CHARACTERS
        // MONSTERS
        // WEAPONS
        // ITEMS
    }
}
