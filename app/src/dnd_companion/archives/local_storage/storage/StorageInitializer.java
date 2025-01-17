package dnd_companion.archives.local_storage.storage;

import dnd_companion.archives.local_storage.storage.setup_commands.ArmorsSetupCommand;
import dnd_companion.archives.local_storage.storage.setup_commands.FolderHierarquySetupCommand;
import dnd_companion.archives.local_storage.storage.setup_commands.ItemsSetupCommand;
import dnd_companion.archives.local_storage.storage.setup_commands.SystemOptionsSetupCommand;
import dnd_companion.archives.local_storage.storage.setup_commands.UnitsSetupCommand;
import dnd_companion.archives.local_storage.storage.setup_commands.WeaponsSetupCommand;
import dnd_companion.common.CommandManager;

public class StorageInitializer extends CommandManager
{
	public FolderHierarquySetupCommand setup_collections() {
		return new FolderHierarquySetupCommand().execute();
	}
	public SystemOptionsSetupCommand setup_options() {
		return new SystemOptionsSetupCommand().execute();
	}
	public ArmorsSetupCommand setup_armors() {
		return new ArmorsSetupCommand().execute();
	}
	public WeaponsSetupCommand setup_weapons() {
		return new WeaponsSetupCommand().execute();
	}
	public ItemsSetupCommand setup_items() {
		return new ItemsSetupCommand().execute();
	}
	public UnitsSetupCommand setup_units() {
		return new UnitsSetupCommand().execute();
	}
}
