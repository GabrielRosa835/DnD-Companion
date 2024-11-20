package dnd_companion.game_helper.local_storage.data_structure.data;

import dnd_companion.game_helper.local_storage.Data;

public record OptionData(String name, String collection, Object[] options) implements Data {}
