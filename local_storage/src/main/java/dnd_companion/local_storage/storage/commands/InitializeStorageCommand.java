package dnd_companion.local_storage.storage.commands;

import dnd_companion.local_storage.models.common.Command;
import dnd_companion.local_storage.storage.StorageBuilder;
import dnd_companion.local_storage.storage.StorageSetup;

public class InitializeStorageCommand extends Command<Boolean>
{
	public InitializeStorageCommand() {
		this.message = "Failed to initialize data storage";
	}
	@Override public void code() {
		StorageBuilder storage_builder = new StorageBuilder();
		StorageSetup storage_setup = new StorageSetup();
		storage_builder.clear_data();
		storage_setup.setup_folder_hierarquy();
		storage_setup.setup_system_options();
		storage_setup.setup_units();
		storage_setup.setup_items();
		storage_setup.setup_armors();
		storage_setup.setup_weapons();
		this.result = true;
		this.message = "Data storage was successfully initialized";
	}
}
