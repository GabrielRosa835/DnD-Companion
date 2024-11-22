package dnd_companion.game_helper.local_storage.storage_build;

public class StorageBuilder 
{
	public static boolean create_directory(String dir_path) {
		return new CreateDirectoryCommand(dir_path).execute().status();
	}
	public static boolean setup_directory_hierarquy() {
		return new CreateDirectoryHierarquyCommand().execute().status();
	}
}
