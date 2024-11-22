package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.data.structure.components.*;
import dnd_companion.game_helper.local_storage.system_components.Data;

public record WeaponData (
	String name,
	String collection,
	ItemBasicProperties properties,
	String category,
	String type,
	DamageCollection damage,
	Object[] martial_properties,
	String mastery
) implements Data {}
