package dnd_companion.common.exceptions;

public class InvalidDataException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String message) {
		super(message);
	}
}
