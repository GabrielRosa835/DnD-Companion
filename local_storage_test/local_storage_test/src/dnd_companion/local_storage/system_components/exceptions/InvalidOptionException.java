package src.system_components.exceptions;

public class InvalidOptionException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidOptionException(String message) {
        super(message);
    }
}
