package dnd_companion.storage.archives.build_commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DirectoryAlreadyExistsException;

public class CreateDirectoryCommand extends Command<String>
{
	private final String dir_path;

	public CreateDirectoryCommand(String dir_path) {
		this.dir_path = dir_path;
		this.message = "Failed to create directory: " + dir_path;
	}

	@Override public void code() throws IOException, DirectoryAlreadyExistsException {
		Path file = Paths.get(dir_path);
		if (Files.exists(file)) {
			throw new DirectoryAlreadyExistsException("Directory already exists: " + dir_path);
		}
		Files.createDirectories(Paths.get(dir_path));
		this.result = dir_path;
		this.message = "Directory successfully created: " + dir_path;
   	}
}
