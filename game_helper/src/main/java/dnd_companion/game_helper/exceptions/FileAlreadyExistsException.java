package dnd_companion.game_helper.exceptions;

public class FileAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public FileAlreadyExistsException(String message) {
		super(message);
	}
}
