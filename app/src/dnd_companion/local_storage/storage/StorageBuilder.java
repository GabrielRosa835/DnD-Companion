package dnd_companion.local_storage.storage;

import dnd_companion.common.CommandManager;
import dnd_companion.local_storage.storage.commands.ClearStorageCommand;
import dnd_companion.local_storage.storage.commands.CreateDirectoryCommand;
import dnd_companion.local_storage.storage.commands.InitializeStorageCommand;

public class StorageBuilder extends CommandManager
{
	public CreateDirectoryCommand create_directory(String dir_path) {
		return new CreateDirectoryCommand(dir_path).execute();
	}
	public ClearStorageCommand clear_data() {
		return new ClearStorageCommand().execute();
	}
	public InitializeStorageCommand initialize() {
		return new InitializeStorageCommand().execute();
	}
}
