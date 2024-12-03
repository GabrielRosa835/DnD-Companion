package src.data_structure.json.items.weapons;

import src.data_structure.json.templates.OptionData;

public record WeaponCategoryData(String... options) implements OptionData<String> {
    public WeaponCategoryData() {
        this(
                "Simple",
                "Martial"
        );
    }

    @Override
    public String collection() {
        return "weapons";
    }

    @Override
    public String file_name() {
        return "weapon-categories";
    }
}
