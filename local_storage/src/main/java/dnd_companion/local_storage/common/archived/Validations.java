package dnd_companion.local_storage.common.archived;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validations
{
	public static boolean check_file_existance(String file_path) {
		Path file = Paths.get(file_path);

        if (Files.exists(file)) {
            return true;
        } else {
        	return false;
        }
	}
}
