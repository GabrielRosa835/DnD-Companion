package dnd_companion.common.exceptions;

public class DirectoryAlreadyExistsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public DirectoryAlreadyExistsException(String message) {
		super(message);
	}
}
