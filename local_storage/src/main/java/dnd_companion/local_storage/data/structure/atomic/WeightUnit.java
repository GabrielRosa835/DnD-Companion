package dnd_companion.local_storage.data.structure.atomic;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;

public record WeightUnit(String name, String abbreviation, double normalizing_factor) implements AtomicUnit {}
