package dnd_companion.storage.archives;

import dnd_companion.common.CommandManager;
import dnd_companion.storage.archives.build_commands.ClearStorageCommand;
import dnd_companion.storage.archives.build_commands.CreateDirectoryCommand;
import dnd_companion.storage.archives.build_commands.InitializeStorageCommand;

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
