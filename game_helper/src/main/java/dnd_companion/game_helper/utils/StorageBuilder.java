package dnd_companion.game_helper.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import dnd_companion.game_helper.exceptions.FileAlreadyExistsException;

public class StorageBuilder 
{
	public static boolean create_directory(String dir_path) {
        try {
        	LSValidations.check_file_existance(dir_path);
        	try {
        		Files.createDirectories(Paths.get(dir_path));
        		ToolBox.print("Directory successfully created: \"%s\"", dir_path);
        		return true;
        	} catch (IOException e) {
        		ToolBox.print_err(e);
        		return false;
        	}
        } catch (FileAlreadyExistsException e) {
        	ToolBox.print_err(e);
        	return false;
        }
   	}
}
