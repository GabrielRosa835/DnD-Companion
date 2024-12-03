package dnd_companion.local_storage.storage_build;

import dnd_companion.local_storage.storage_build.storage_setup.ArmorsSetupCommand;
import dnd_companion.local_storage.storage_build.storage_setup.OptionsSetupCommand;

public class StorageBuilder
{
	public static boolean create_directory(String dir_path) {
		return new CreateDirectoryCommand(dir_path).execute().status();
	}
	public static boolean setup_directory_hierarquy() {
		return new CreateDirectoryHierarquyCommand().execute().status();
	}
	public static boolean setup_options() {
		return new OptionsSetupCommand().execute().status();
	}
	public static boolean setup_armors() {
		return new ArmorsSetupCommand().execute().status();
	}
}
