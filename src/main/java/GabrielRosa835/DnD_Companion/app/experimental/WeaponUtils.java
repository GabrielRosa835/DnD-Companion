package app.experimental;

import app.rpg.elements.options.*;
import app.rpg.elements.options.abilityScores.*;
import app.rpg.elements.options.weaponProperties.*;

public class WeaponUtils {

	public static boolean isFinesse(WeaponOption weapon) {
		return weapon.properties().content().stream()
				.anyMatch(p -> p.equals(WEAPON_PROPERTY_FINESSE.use));
	}
}
