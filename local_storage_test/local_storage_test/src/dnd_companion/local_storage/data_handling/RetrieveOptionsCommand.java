package src.data_handling;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import src.data_structure.json.templates.OptionData;
import src.system_components.Command;
import src.system_components.DataKey;
import src.system_components.ToolBox;

public class RetrieveOptionsCommand<T> extends Command {
    private DataKey key;
    private ObjectReader reader;

    private T[] result;

    public T[] result() {
        return this.result;
    }

    public RetrieveOptionsCommand(DataKey key) {
        super();
        try {
            this.key = key;
            this.reader = new ObjectMapper().readerFor(Class.forName(key.type()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RetrieveOptionsCommand<T> execute() {
        try {
            File file = new File(ToolBox.create_file_path(key));
            OptionData<T> data = reader.readValue(file);
            ToolBox.print("Options retrieved successfully: (%s) %s", data.getClass().getSimpleName(), Arrays.toString(data.options()));
            this.result = data.options();
            this.status = true;
        } catch (Exception e) {
            ToolBox.print_err(e);
            this.result = null;
            this.status = false;
        }
        return this;
    }
}
