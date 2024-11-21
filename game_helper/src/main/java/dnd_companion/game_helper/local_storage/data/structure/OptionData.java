package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;

public record OptionData(String name, String collection, AtomicOption[] options) implements Data {}
