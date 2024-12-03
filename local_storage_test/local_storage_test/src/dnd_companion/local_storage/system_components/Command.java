package src.system_components;

public abstract class Command {
    protected boolean status = false;

    public boolean status() {
        return this.status;
    }

    protected String message = null;

    public String message() {
        return this.message;
    }

    public abstract Command execute();
}
