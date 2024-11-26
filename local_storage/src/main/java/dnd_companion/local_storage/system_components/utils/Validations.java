package dnd_companion.local_storage.system_components.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validations
{
	public static boolean check_file_existance(String file_path) {
		Path file = Paths.get(file_path);

        if (Files.exists(file)) {
            ToolBox.print("File found: \"%s\"", file_path);
            return true;
        } else {
        	ToolBox.print("File not found: \"%s\"", file_path);
        	return false;
        }
	}
}
