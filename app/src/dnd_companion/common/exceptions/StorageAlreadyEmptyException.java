package dnd_companion.common.exceptions;

public class StorageAlreadyEmptyException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public StorageAlreadyEmptyException(String message) {
		super(message);
	}
}