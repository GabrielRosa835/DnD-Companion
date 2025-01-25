package dnd_companion.entities.addons.components;

import dnd_companion.entities.weapon_related.WeaponData;

public class WeaponRange
{
	private Length min_range;
	public Length min_range() {return this.min_range;}

	private Length max_range;
	public Length max_range() {return this.max_range;}

	public WeaponRange(Length min_range, Length max_range) {
		this.min_range = min_range;
		this.max_range = max_range;
	}
	public WeaponRange(WeaponData data) {
		this(
			new Length(data.min_range_value(), data.range_unit()),
			new Length(data.max_range_value(), data.range_unit())
		);
	}
}
