package dnd_companion.local_storage.storage;

import dnd_companion.local_storage.common.command.CommandManager;
import dnd_companion.local_storage.storage.setup_commands.ArmorsSetupCommand;
import dnd_companion.local_storage.storage.setup_commands.FolderHierarquySetupCommand;
import dnd_companion.local_storage.storage.setup_commands.ItemsSetupCommand;
import dnd_companion.local_storage.storage.setup_commands.SystemOptionsSetupCommand;
import dnd_companion.local_storage.storage.setup_commands.UnitsSetupCommand;
import dnd_companion.local_storage.storage.setup_commands.WeaponsSetupCommand;

public class StorageSetup extends CommandManager
{
	public StorageSetup setup_folder_hierarquy() {
		this.last_command = new FolderHierarquySetupCommand().execute();
		return this;
	}
	public StorageSetup setup_system_options() {
		this.last_command = new SystemOptionsSetupCommand().execute();
		return this;
	}
	public StorageSetup setup_armors() {
		this.last_command = new ArmorsSetupCommand().execute();
		return this;
	}
	public StorageSetup setup_weapons() {
		this.last_command = new WeaponsSetupCommand().execute();
		return this;
	}
	public StorageSetup setup_items() {
		this.last_command = new ItemsSetupCommand().execute();
		return this;
	}
	public StorageSetup setup_units() {
		this.last_command = new UnitsSetupCommand().execute();
		return this;
	}
}
