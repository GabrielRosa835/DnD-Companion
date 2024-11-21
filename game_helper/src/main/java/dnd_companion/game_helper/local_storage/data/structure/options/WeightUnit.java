package dnd_companion.game_helper.local_storage.data.structure.options;

public record WeightUnit(String name, String abbreviation, double normalizing_factor) implements AtomicOptionUnit {}
