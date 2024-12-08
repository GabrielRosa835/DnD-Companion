package dnd_companion.local_storage.storage;

import dnd_companion.local_storage.common.command.CommandManager;
import dnd_companion.local_storage.storage.storage_setup_commands.ArmorsSetupCommand;
import dnd_companion.local_storage.storage.storage_setup_commands.FolderHierarquySetupCommand;
import dnd_companion.local_storage.storage.storage_setup_commands.OptionsSetupCommand;

public class StorageSetup extends CommandManager
{
	public StorageSetup setup_folder_hierarquy() {
		this.last_command = new FolderHierarquySetupCommand().execute();
		return this;
	}
	public StorageSetup setup_options() {
		this.last_command = new OptionsSetupCommand().execute();
		return this;
	}
	public StorageSetup setup_armors() {
		this.last_command = new ArmorsSetupCommand().execute();
		return this;
	}
}
