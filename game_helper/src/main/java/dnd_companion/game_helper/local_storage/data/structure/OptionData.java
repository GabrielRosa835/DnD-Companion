package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;
import dnd_companion.game_helper.local_storage.system_components.Data;

public record OptionData(String name, String collection, AtomicOption[] options) implements Data {}
