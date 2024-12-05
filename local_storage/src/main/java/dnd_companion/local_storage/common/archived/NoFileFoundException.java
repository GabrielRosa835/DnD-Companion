package dnd_companion.local_storage.common.archived;

public class NoFileFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

    public NoFileFoundException(String message) {
        super(message);
    }
}
