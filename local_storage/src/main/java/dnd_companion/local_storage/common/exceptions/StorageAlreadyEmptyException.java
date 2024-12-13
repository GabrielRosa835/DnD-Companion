package dnd_companion.local_storage.common.exceptions;

public class StorageAlreadyEmptyException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public StorageAlreadyEmptyException(String message) {
		super(message);
	}
}