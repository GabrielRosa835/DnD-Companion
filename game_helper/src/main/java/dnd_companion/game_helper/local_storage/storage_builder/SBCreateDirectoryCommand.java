package dnd_companion.game_helper.local_storage.storage_builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import dnd_companion.game_helper.exceptions.FileAlreadyExistsException;
import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.LSValidations;
import dnd_companion.game_helper.utils.ToolBox;

public class SBCreateDirectoryCommand extends Command
{
	private String dir_path;
	
	public SBCreateDirectoryCommand(String dir_path) {
		this.dir_path = dir_path;
	}

	public SBCreateDirectoryCommand execute() {
        try {
        	LSValidations.check_file_existance(dir_path);
        	try {
        		Files.createDirectories(Paths.get(dir_path));
        		ToolBox.print("Directory successfully created: \"%s\"", dir_path);
        		status = true;
        	} catch (IOException e) {
        		ToolBox.print_err(e);
        		status = false;
        	}
        } catch (FileAlreadyExistsException e) {
        	ToolBox.print_err(e);
        	status = false;
        }
        return this;
   	}
}
