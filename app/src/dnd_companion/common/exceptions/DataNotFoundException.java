package dnd_companion.common.exceptions;

public class DataNotFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}