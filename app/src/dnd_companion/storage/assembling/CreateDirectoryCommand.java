package dnd_companion.storage.assembling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dnd_companion.common.design_patterns.Command;
import dnd_companion.common.tools.ToolBox;

public class CreateDirectoryCommand implements Command
{
	private final String directory_path;

	public CreateDirectoryCommand(String directory_path) {
		this.directory_path = directory_path;
	}

	public void execute() {
		Path file = Paths.get(directory_path);
		if (Files.exists(file)) {
			return;
		}
		try {
			Files.createDirectories(file);
		} catch (IOException e) {
			ToolBox.exceptionHandler(e);
		}
   	}
}
