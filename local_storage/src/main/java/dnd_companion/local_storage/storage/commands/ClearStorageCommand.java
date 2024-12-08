package dnd_companion.local_storage.storage.commands;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;

public class ClearStorageCommand extends Command<Boolean> 
{
	public ClearStorageCommand execute() {
		try {
			Path data = Paths.get("data");
			String message;
			if(Files.exists(data)) {
				Files.walkFileTree(data, new SimpleFileVisitor<Path>() {
					@Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						Files.delete(file);
						return FileVisitResult.CONTINUE;
					}
					@Override public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					}
				});
				message = "Storage cleared successfully";
			} else {
				message = "No data found to clear";
			}
			this.status = true;
			this.result = true;
			this.message = message;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to clear storage";
		}
		return this;
	}
}
