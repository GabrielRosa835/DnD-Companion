package dnd_companion.local_storage.storage;

import dnd_companion.local_storage.common.command.CommandManager;
import dnd_companion.local_storage.storage.commands.ClearStorageCommand;
import dnd_companion.local_storage.storage.commands.CreateDirectoryCommand;
import dnd_companion.local_storage.storage.commands.InitializeStorageCommand;

public class StorageBuilder extends CommandManager
{
	public StorageBuilder create_directory(String dir_path) {
		this.last_command = new CreateDirectoryCommand(dir_path).execute();
		return this;
	}
	public StorageBuilder clear_data() {
		this.last_command = new ClearStorageCommand().execute();
		return this;
	}
	public StorageBuilder initialize() {
		this.last_command = new InitializeStorageCommand().execute();
		return this;
	}
}
