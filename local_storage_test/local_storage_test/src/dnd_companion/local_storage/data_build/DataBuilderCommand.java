package src.data_build;

import src.data_structure.json.templates.Data;
import src.system_components.Command;

public abstract class DataBuilderCommand<T extends Data> extends Command {
    protected T result;

    public T result() {
        return this.result;
    }

    public DataBuilderCommand() {
        super();
        this.result = null;
    }
}
