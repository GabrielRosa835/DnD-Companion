package dnd_companion.archives.local_storage.storage.build_commands;

import dnd_companion.archives.local_storage.storage.StorageBuilder;
import dnd_companion.archives.local_storage.storage.StorageInitializer;
import dnd_companion.common.Command;

public class InitializeStorageCommand extends Command<Boolean>
{
	private static StorageBuilder builder = new StorageBuilder();
	private static StorageInitializer init = new StorageInitializer();
	
	public InitializeStorageCommand() {
		this.message = "Failed to initialize data storage";
	}
	@Override public void code() {
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
