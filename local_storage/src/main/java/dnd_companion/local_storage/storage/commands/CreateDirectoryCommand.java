package dnd_companion.local_storage.storage.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;

public class CreateDirectoryCommand extends Command<String>
{
	private String dir_path;

	public CreateDirectoryCommand(String dir_path) {
		this.dir_path = dir_path;
	}

	@Override
	public CreateDirectoryCommand execute() {
		try {
			String message;
			Path file = Paths.get(dir_path);
			if (!Files.exists(file)) {
    			Files.createDirectories(Paths.get(dir_path));
    			message = String.format("Directory successfully created: \"%s\"", dir_path);
			} else {
				message = String.format("Directory already exists: \"%s\"", dir_path);
			}
			this.status = true;
			this.result = dir_path;
			this.message = message;
		} catch (IOException e) {
			ToolBox.print_err(e);
			this.clear();
		}
        return this;
   	}
}
