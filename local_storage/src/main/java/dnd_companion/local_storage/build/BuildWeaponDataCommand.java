package dnd_companion.local_storage.build;

import dnd_companion.local_storage.structure.components.items.weapons.WeaponComponent;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;

public class BuildWeaponDataCommand extends DataBuilderCommand<WeaponData>
{
	private final WeaponComponent component;

	public BuildWeaponDataCommand(WeaponComponent component) {
		this.component = component;
	}

	public void code() {
		this.result = new WeaponData(
				component.
				);
	}

}
