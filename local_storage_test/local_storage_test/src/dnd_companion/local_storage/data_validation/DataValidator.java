package src.data_validation;

import java.util.ArrayList;
import java.util.Collection;

import src.data_structure.json.templates.AtomicUnit;
import src.system_components.DataKey;

public class DataValidator {
    public static <T> T validate_option(DataKey key, T option) {
        return new ValidateOptionCommand<>(key, option).execute().result();
    }

    public static <T> T[] validate_options(DataKey key, T[] options) {
        Collection<T> validated_options = new ArrayList<>();
        for (T option : options) {
            validated_options.add(new ValidateOptionCommand<>(key, option).execute().result());
        }
        return validated_options.toArray(options.clone());
    }

    public static <T extends AtomicUnit> T validate_unit(DataKey key, String unit) {
        return new ValidateUnitCommand<T>(key, unit).execute().result();
    }
}
