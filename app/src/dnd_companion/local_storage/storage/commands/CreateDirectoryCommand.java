package dnd_companion.local_storage.storage.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DirectoryAlreadyExistsException;

public class CreateDirectoryCommand extends Command<String>
{
	private String dir_path;

	public CreateDirectoryCommand(String dir_path) {
		this.dir_path = dir_path;
	}

	@Override public void code() throws IOException, DirectoryAlreadyExistsException {
		Path file = Paths.get(dir_path);
		if (Files.exists(file)) {
			throw new DirectoryAlreadyExistsException(String.format("Directory already exists: \"%s\"", dir_path));
		}
		Files.createDirectories(Paths.get(dir_path));
		this.result = dir_path;
		this.message = String.format("Directory successfully created: \"%s\"", dir_path);
   	}
}
