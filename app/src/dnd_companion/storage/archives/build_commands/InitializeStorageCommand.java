package dnd_companion.storage.archives.build_commands;

import dnd_companion.common.Command;
import dnd_companion.storage.archives.StorageBuilder;
import dnd_companion.storage.archives.StorageInitializer;

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
