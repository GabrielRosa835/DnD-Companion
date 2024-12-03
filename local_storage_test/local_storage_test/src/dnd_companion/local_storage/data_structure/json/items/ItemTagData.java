package src.data_structure.json.items;

import src.data_structure.json.templates.OptionData;

public record ItemTagData(String... options)
        implements OptionData<String> {
    public ItemTagData() {
        this(
                "Ammunition",
                "Armor",
                "Weapon",
                "Food and Drink",
                "Adventuring Gear",
                "Tool",
                "Instrument"
        );
    }

    @Override
    public String collection() {
        return "items";
    }

    @Override
    public String file_name() {
        return "item-tags";
    }
}
