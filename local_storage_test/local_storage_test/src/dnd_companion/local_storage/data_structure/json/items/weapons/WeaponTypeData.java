package src.data_structure.json.items.weapons;

import src.data_structure.json.templates.OptionData;

public record WeaponTypeData(String... options) implements OptionData<String> {
    public WeaponTypeData() {
        this(
                "Melee",
                "Ranged"
        );
    }

    @Override
    public String collection() {
        return "weapons";
    }

    @Override
    public String file_name() {
        return "weapon-types";
    }
}
