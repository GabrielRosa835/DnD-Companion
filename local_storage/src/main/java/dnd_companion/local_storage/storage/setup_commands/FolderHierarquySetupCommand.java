package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.storage.StorageBuilder;
import dnd_companion.local_storage.storage.StorageMetadata;

public class FolderHierarquySetupCommand extends Command<Boolean>
{
	private static StorageBuilder storage_builder = new StorageBuilder();
	
	public FolderHierarquySetupCommand() {
		this.message = "Failed to setup directories";
	}
	
	@Override public void code() {
		for (StorageMetadata.DirRef directory : StorageMetadata.directory_hierarquy.values()) {
			storage_builder.create_directory(directory.path());
		}
		this.result = true;
		this.message = "Directories' setup was successful";
	}
}
