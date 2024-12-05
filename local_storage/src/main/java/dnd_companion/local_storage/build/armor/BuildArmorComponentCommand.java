package dnd_companion.local_storage.build.armor;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.structure.components.items.armors.ArmorComponent;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class BuildArmorComponentCommand extends Command<ArmorComponent>
{
	private ArmorData data;
	
	
	
	public BuildArmorComponentCommand(ArmorData data) {
		super();
		this.data = data;
	}

	public BuildArmorComponentCommand execute() {
		
	}
}
