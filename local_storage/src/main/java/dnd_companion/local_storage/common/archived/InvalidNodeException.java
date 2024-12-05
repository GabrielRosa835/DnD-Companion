package dnd_companion.local_storage.common.archived;

public class InvalidNodeException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public InvalidNodeException(String message) {
		super(message);
	}
}
