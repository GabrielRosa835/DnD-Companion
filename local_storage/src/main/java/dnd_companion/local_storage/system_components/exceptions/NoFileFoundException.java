package dnd_companion.local_storage.system_components.exceptions;

public class NoFileFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

    public NoFileFoundException(String message) {
        super(message);
    }
}
