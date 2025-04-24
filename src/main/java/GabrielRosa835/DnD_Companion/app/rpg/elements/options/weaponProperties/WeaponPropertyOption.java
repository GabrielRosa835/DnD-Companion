package app.rpg.elements.options.weaponProperties;

import app.rpg.elements.models.Option;

import java.util.*;

public record WeaponPropertyOption(
		String name
) implements Option {
	public static Set<WeaponPropertyOption> fixed = Set.of(
			WEAPON_PROPERTY_AMMUNITION.use,
			WEAPON_PROPERTY_FINESSE.use,
			WEAPON_PROPERTY_HEAVY.use,
			WEAPON_PROPERTY_LIGHT.use,
			WEAPON_PROPERTY_LOADING.use,
			WEAPON_PROPERTY_REACH.use,
			WEAPON_PROPERTY_THROWN.use,
			WEAPON_PROPERTY_TWO_HANDED.use,
			WEAPON_PROPERTY_VERSATILE.use
	);
}
