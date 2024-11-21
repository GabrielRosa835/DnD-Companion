package dnd_companion.game_helper.exceptions;

public class InvalidOptionException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public InvalidOptionException(String message) {
		super(message);
	}
}
