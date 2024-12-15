package dnd_companion.local_storage.archived;

public class InvalidUnitException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidUnitException(String message) {
		super(message);
	}
}
