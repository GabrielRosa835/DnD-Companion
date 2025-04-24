package app.rpg.elements.options;

import app.rpg.elements.models.Option;

import java.util.List;

public record AmmunitionOption(
		String name,
		List<WeaponOption> allowedWeaponOptions
) implements Option {
	//
}
