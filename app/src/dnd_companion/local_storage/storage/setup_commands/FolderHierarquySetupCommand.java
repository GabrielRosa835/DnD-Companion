package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.common.Command;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.storage.StorageBuilder;

public class FolderHierarquySetupCommand extends Command<Boolean>
{
	private static StorageBuilder storage_builder = new StorageBuilder();
	
	public FolderHierarquySetupCommand() {
		this.message = "Failed to setup directories";
	}
	
	@Override public void code() {
		for (CollectionREF collection : Collections.all()) {
			storage_builder.create_directory(collection.path());
		}
		this.result = true;
		this.message = "Directories' setup was successful";
	}
}
