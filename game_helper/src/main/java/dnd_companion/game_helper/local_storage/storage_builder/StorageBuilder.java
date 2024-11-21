package dnd_companion.game_helper.local_storage.storage_builder;

public class StorageBuilder 
{
	public static boolean create_directory(String dir_path) {
		return new SBCreateDirectoryCommand(dir_path).execute().status();
	}
	public static boolean setup_directory_hierarquy() {
		return new SBCreateDirectoryHierarquyCommand().execute().status();
	}
}
