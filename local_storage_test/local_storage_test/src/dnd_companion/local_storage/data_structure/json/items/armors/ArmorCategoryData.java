package src.data_structure.json.items.armors;

import src.data_structure.json.templates.OptionData;

public record ArmorCategoryData(String... options)
        implements OptionData<String> {
    public ArmorCategoryData() {
        this(
                "None",
                "Shield",
                "Light",
                "Medium",
                "Heavy"
        );
    }

    @Override
    public String collection() {
        return "armors";
    }

    @Override
    public String file_name() {
        return "armor-categories";
    }
}
