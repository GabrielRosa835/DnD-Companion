package src.data_structure.java.items.armors;

import src.data_structure.json.items.armors.ArmorCategoryData;
import src.data_validation.DataValidator;
import src.system_components.DataKey;

public class ArmorCategory {
    private String name;

    public String name() {
        return this.name;
    }

    public ArmorCategory(String name) {
        this.name = DataValidator.validate_option(new DataKey(ArmorCategoryData.class), name);
    }
}
