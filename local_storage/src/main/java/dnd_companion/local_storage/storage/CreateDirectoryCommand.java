package dnd_companion.local_storage.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.archived.Validations;

public class CreateDirectoryCommand extends Command
{
	private String dir_path;

	public CreateDirectoryCommand(String dir_path) {
		this.dir_path = dir_path;
	}

	@Override
	public CreateDirectoryCommand execute() {
		try {
			if (!Validations.check_file_existance(dir_path)) {
    			Files.createDirectories(Paths.get(dir_path));
    			ToolBox.print("Directory successfully created: \"%s\"", dir_path);
			} else {
				ToolBox.print("Directory already exists: \"%s\"", dir_path);
			}
			status = true;
		} catch (IOException e) {
			ToolBox.print_err(e);
			status = false;
		}
        return this;
   	}
}
