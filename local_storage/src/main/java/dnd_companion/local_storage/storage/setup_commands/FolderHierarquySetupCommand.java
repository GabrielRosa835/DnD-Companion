package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.storage.StorageBuilder;
import dnd_companion.local_storage.storage.StorageMetadata;

public class FolderHierarquySetupCommand extends Command<Boolean>
{
	private static StorageBuilder storage_builder = new StorageBuilder();
	
	@Override
	public FolderHierarquySetupCommand execute() {
		try {
			for (StorageMetadata.DirRef directory : StorageMetadata.directory_hierarquy.values()) {
				storage_builder.create_directory(directory.path());
			}
			this.status = true;
			this.result = true;
			this.message = "Directories' setup was successful";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to setup directories";
		}
		return this;
	}
}
