package dnd_companion.game_helper.local_storage.data.structure.options;

// Also known as monetary currency
public record PriceUnit(String name, String abbreviation, double normalizing_factor) implements AtomicOptionUnit {}
