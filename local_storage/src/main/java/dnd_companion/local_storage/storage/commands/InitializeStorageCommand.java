package dnd_companion.local_storage.storage.commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.storage.StorageBuilder;
import dnd_companion.local_storage.storage.StorageSetup;

public class InitializeStorageCommand extends Command<Boolean>
{
	private StorageBuilder storage_builder = new StorageBuilder();
	private StorageSetup storage_setup = new StorageSetup();
	
	public InitializeStorageCommand execute() {
		try {
			storage_builder.clear_data();
			storage_setup.setup_folder_hierarquy();
			storage_setup.setup_options();
			storage_setup.setup_armors();
			
			this.status = false;
			this.result = false;
			this.message = "Data storage was successfully initialized";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to initialize data storage";
		}
		return this;
	}
}
