package dnd_companion.local_storage.common.exceptions;

public class DataAlreadyExistsException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistsException(String message) {
		super(message);
	}
}
