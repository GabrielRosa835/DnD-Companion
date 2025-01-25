package dnd_companion.storage.assembling;

import dnd_companion.common.design_patterns.Facade;

public class StorageAssembler implements Facade
{
	public static void createDirectory(String dir_path) {
		new CreateDirectoryCommand(dir_path).execute();
	}
	public static void clearData() {
		new ClearStorageCommand().execute();
	}
	public static void setup() {
		new SetupStorageCommand().execute();
	}
}
