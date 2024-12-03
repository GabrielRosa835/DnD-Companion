package src.data_build;

import src.data_structure.java.items.ItemTag;
import src.data_structure.java.items.weapons.WeaponRange;
import src.data_structure.java.system.Damage;
import src.data_structure.java.system.Dice;
import src.data_structure.java.system.units.Length;
import src.data_structure.java.system.units.Price;
import src.data_structure.java.system.units.Weight;
import src.data_structure.json.items.weapons.WeaponData;

public class BuildWeaponDataCommand extends DataBuilderCommand<WeaponData> {
    private String name;
    private Price price;
    private Weight weight;
    private ItemTag[] tags;
    private String description;
    private String category;
    private String type;
    private Damage damage;
    private String[] properties;
    private String mastery;
    private WeaponRange range;
    private Ammo
    private Dice versatile_dice;

    public BuildWeaponDataCommand(
            String name,
            Price price,
            Weight weight,
            String[] tags,
            String description,
            String category,
            String type,
            String damage_dice_type, int damage_dice_amount, String damage_type,
            String[] properties,
            String mastery,
            Length min_range,
            Length max_range,
            String versatile_dice) {
        super();
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.tags = tags;
        this.description = description;
        this.category = category;
        this.type = type;
        this.damage_dice_type = damage_dice_type;
        this.damage_dice_amount = damage_dice_amount;
        this.damage_type = damage_type;
        this.properties = properties;
        this.mastery = mastery;
        this.min_range = min_range;
        this.max_range = max_range;
        this.versatile_dice = versatile_dice;
    }


}
