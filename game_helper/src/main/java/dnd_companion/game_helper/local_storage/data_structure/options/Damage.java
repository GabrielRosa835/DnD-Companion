package dnd_companion.game_helper.local_storage.data_structure.options;

import dnd_companion.game_helper.local_storage.data_structure.options.dice.DiceCollection;

public record Damage(String damage_type, DiceCollection dices) {}
