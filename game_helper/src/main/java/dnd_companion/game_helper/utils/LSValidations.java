package dnd_companion.game_helper.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dnd_companion.game_helper.exceptions.NoFileFoundException;

public class LSValidations
{
	public static boolean check_file_existance(String file_path) {
		Path file = Paths.get(file_path);

        if (Files.exists(file)) {
            System.out.println(String.format("File found: \"%s\"", file_path));
            return true;
        } else {
            throw new NoFileFoundException("File not found");
        }
	}
}
