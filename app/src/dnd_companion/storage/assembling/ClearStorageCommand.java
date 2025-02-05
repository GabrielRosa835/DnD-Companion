package dnd_companion.storage.assembling;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import dnd_companion.common.BaseCollections;
import dnd_companion.common.design_patterns.Command;

public class ClearStorageCommand implements Command
{
	public void execute() {
		Path path = Paths.get(BaseCollections.DATA.path());
		if(!Files.exists(path)) {
			return;
		}
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
