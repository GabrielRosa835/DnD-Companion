package dnd_companion.local_storage.archived;

public class FileAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public FileAlreadyExistsException(String message) {
		super(message);
	}
}
