package dnd_companion.local_storage.system_components.exceptions;

public class FileAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public FileAlreadyExistsException(String message) {
		super(message);
	}
}
