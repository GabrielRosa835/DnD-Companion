package src.data_handling;

import src.data_structure.json.templates.Data;
import src.system_components.DataKey;

public class DataHandler {
    public static boolean save(Data data) {
        return new SaveCommand(data).execute().status();
    }

    public static <T extends Data> Data retrieve(DataKey key) {
        return new RetrieveDataCommand<T>(key).execute().result();
    }

    public static <T extends Data> boolean exists(DataKey key) {
        return new RetrieveDataCommand<T>(key).execute().status();
    }

    public static <T> T[] retrieve_options(DataKey key) {
        return new RetrieveOptionsCommand<T>(key).execute().result();
    }
}
