package dnd_companion.local_storage.common.exceptions;

public class DirectoryAlreadyExistsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public DirectoryAlreadyExistsException(String message) {
		super(message);
	}
}
