package dnd_companion.local_storage.structure.elements;

import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;
import dnd_companion.local_storage.structure.elements.system.units.LengthComponent;

public class WeaponRange 
{
	private LengthComponent min_range;
	public LengthComponent min_range() {return this.min_range;}
	
	private LengthComponent max_range;
	public LengthComponent max_range() {return this.max_range;}
	
	public WeaponRange(LengthComponent min_range, LengthComponent max_range) {
		this.min_range = min_range;
		this.max_range = max_range;
	}
	public WeaponRange(WeaponData data) {
		this(
			new LengthComponent(data.min_range_value(), data.range_unit()),
			new LengthComponent(data.max_range_value(), data.range_unit())
		);
	}
}
