package src.data_structure.json.atomic;

import src.data_structure.json.templates.AtomicUnit;

public record WeightUnit(String name, String abbreviation, double normalizing_factor)
        implements AtomicUnit {
    public WeightUnit {
        abbreviation = abbreviation.toUpperCase();
    }
}
