package dnd_companion.storage.archives.setup_commands;

import dnd_companion.common.Command;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.storage.archives.StorageBuilder;

public class FolderHierarquySetupCommand extends Command<Boolean>
{
	private static StorageBuilder storage_builder = new StorageBuilder();
	
	public FolderHierarquySetupCommand() {
		this.message = "Failed to setup directories";
	}
	
	@Override public void code() {
		for (CollectionREF collection : new CollectionsMetadata().all()) {
			storage_builder.create_directory(collection.path());
		}
		this.result = true;
		this.message = "Directories' setup was successful";
	}
}
