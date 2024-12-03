package src.data_structure.json.items.weapons;

import src.data_structure.json.templates.Data;
import src.data_structure.json.templates.Item;
import src.system_components.ToolBox;

public record WeaponData(
        String name,
        double price_value,
        String price_unit,
        double weight_value,
        String weight_unit,
        String[] tags,
        String description,
        String category,
        String type,
        int damage_dice_amount,
        String damage_dice_type,
        String damage_type,
        String[] properties,
        String mastery,
        double min_range_value,
        double max_range_value,
        String range_unit,
        String versatile_dice_type
) implements Item, Data {
    @Override
    public String collection() {
        return "weapons";
    }

    @Override
    public String file_name() {
        return ToolBox.to_snake_case(this.name);
    }
}
