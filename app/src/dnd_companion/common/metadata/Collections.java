package dnd_companion.common.metadata;

import java.io.File;
import java.util.HashMap;

import dnd_companion.common.design_patterns.Singleton;

public enum Collections implements Singleton
{
	DATA,

	SYSTEM, ITEMS, CAMPAIGNS, RULES,

	UNITS, DICE_TYPES,

	DAMAGE_TYPES, ACTION_TYPES, CONDITIONS,

	CURRENCIES, LENGTH_UNITS, WEIGHT_UNITS, TIME_UNITS,

	AMMUNITION, ITEM_TAGS, ARMORS, WEAPONS, GENERIC_ITEMS,

	ARMOR_CATEGORIES,

	WEAPON_TYPES, WEAPON_CATEGORIES, WEAPON_MASTERIES, WEAPON_PROPERTIES;

	private static HashMap<Collections, Collections> mapping = new HashMap<>();
	public static HashMap<Collections, Collections> mapping() {return mapping;}

	private static void add(Collections parent, Collections collection) {
		mapping.put(collection, parent);
	}

	public String path() {
		String path = this.name().toLowerCase();
		Collections next = mapping.get(this);
		while(next != null) {
			path = next.name().toLowerCase() + File.separator + path;
			next = mapping.get(next);
		}
		return path;
	}

	static {
		add(null, DATA);

		add(DATA, SYSTEM);
		add(DATA, ITEMS);
		add(DATA, CAMPAIGNS);
		add(DATA, RULES);

		add(SYSTEM, UNITS);
		add(SYSTEM, DICE_TYPES);

		add(RULES, DAMAGE_TYPES);
		add(RULES, ACTION_TYPES);
		add(RULES, CONDITIONS);

		add(UNITS, CURRENCIES);
		add(UNITS, LENGTH_UNITS);
		add(UNITS, WEIGHT_UNITS);
		add(UNITS, TIME_UNITS);

		add(ITEMS, AMMUNITION);
		add(ITEMS, ITEM_TAGS);
		add(ITEMS, ARMORS);
		add(ITEMS, WEAPONS);
		add(ITEMS, GENERIC_ITEMS);

		add(ARMORS, ARMOR_CATEGORIES);

		add(WEAPONS, WEAPON_TYPES);
		add(WEAPONS, WEAPON_CATEGORIES);
		add(WEAPONS, WEAPON_MASTERIES);
		add(WEAPONS, WEAPON_PROPERTIES);
	}
}
