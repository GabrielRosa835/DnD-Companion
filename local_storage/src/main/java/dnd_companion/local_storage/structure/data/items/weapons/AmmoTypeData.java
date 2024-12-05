package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.structure.data.atomic.AmmoType;
import dnd_companion.local_storage.structure.data.templates.OptionData;

public record AmmoTypeData(AmmoType... options) implements OptionData<AmmoType>
{
	public AmmoTypeData() {
		this(
			new AmmoType("Arrow", 5, "CP", 0.8, "OZ", new String[]{"Ammo"}, "Arrows are typically stored in a Quiver (bought separately)."),
			new AmmoType("Bolt", 5, "CP", 1.2, "OZ", new String[]{"Ammo"}, "Bolts are typically stored in a Crossbow Bolt Case (bought separately).")
		);
	}

	@Override
	public String collection() {return "weapons";}
	@Override
	public String file_name() {return "ammo-types";}
}
