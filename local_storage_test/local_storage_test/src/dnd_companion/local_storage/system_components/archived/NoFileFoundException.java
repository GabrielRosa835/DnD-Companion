package src.system_components.archived;

public class NoFileFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoFileFoundException(String message) {
        super(message);
    }
}
