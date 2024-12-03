package src.data_structure.json.items.armors;

import src.data_structure.json.templates.Data;
import src.data_structure.json.templates.Item;
import src.system_components.ToolBox;

public record ArmorData(
        String name,
        double price_value,
        String price_unit,
        double weight_value,
        String weight_unit,
        String[] tags,
        String description,
        String category,
        int armor_class,
        int strength_requirement,
        boolean stealth_disadvantage
) implements Item, Data {
    @Override
    public String collection() {
        return "armors";
    }

    @Override
    public String file_name() {
        return ToolBox.to_snake_case(this.name);
    }
}
