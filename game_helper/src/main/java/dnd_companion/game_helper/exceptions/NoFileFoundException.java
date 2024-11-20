package dnd_companion.game_helper.exceptions;

public class NoFileFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

    public NoFileFoundException(String message) {
        super(message);
    }
}
