package dnd_companion.local_storage.system_components.exceptions;

public class InvalidNodeException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public InvalidNodeException(String message) {
		super(message);
	}
}
