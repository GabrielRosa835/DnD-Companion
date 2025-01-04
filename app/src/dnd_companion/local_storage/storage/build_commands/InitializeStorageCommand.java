package dnd_companion.local_storage.storage.build_commands;

import dnd_companion.common.Command;
import dnd_companion.local_storage.storage.StorageBuilder;
import dnd_companion.local_storage.storage.StorageInitializer;

public class InitializeStorageCommand extends Command<Boolean>
{
	public InitializeStorageCommand() {
		this.message = "Failed to initialize data storage";
	}
	@Override public void code() {
		StorageBuilder builder = new StorageBuilder();
		StorageInitializer init = new StorageInitializer();
		builder.clear_data();
		init.setup_collections();
		init.setup_options();
		init.setup_units();
		init.setup_items();
		init.setup_armors();
		init.setup_weapons();
		this.result = true;
		this.message = "Data storage was successfully initialized";
	}
}
