package dnd_companion.local_storage.storage.commands;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.StorageAlreadyEmptyException;

public class ClearStorageCommand extends Command<Boolean> 
{
	public ClearStorageCommand() {
		this.message = "Failed to clear storage";
	}
	
	@Override public void code() throws IOException, StorageAlreadyEmptyException {
		Path path = Paths.get("data");
		if(!Files.exists(path)) {
			throw new StorageAlreadyEmptyException("The system's storage is already empty");
		}
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			@Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
			@Override public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
		this.result = true;
		this.message = "Storage cleared successfully";
	}
}
