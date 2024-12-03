package src.data_structure.java.items;

import src.data_structure.json.items.ItemTagData;
import src.data_validation.DataValidator;
import src.system_components.DataKey;

public class ItemTag {
    private String name;

    public String name() {
        return this.name;
    }

    public ItemTag(String name) {
        this.name = DataValidator.validate_option(new DataKey(ItemTagData.class), name);
    }
}
