package dnd_companion.game_helper.local_storage;

import java.util.*;

import dnd_companion.game_helper.local_storage.data_structure.data.ArmorData;
import dnd_companion.game_helper.local_storage.data_structure.data.OptionData;
import dnd_companion.game_helper.local_storage.data_structure.data.WeaponData;

public final class CollectionsMap
{
	private static final Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
	public static final Map<String, Class<?>> mapping() {return mapping;}
	
	static {
        mapping.put("options", OptionData.class);
        mapping.put("armors", ArmorData.class);
        mapping.put("weapons", WeaponData.class);
    }
}
