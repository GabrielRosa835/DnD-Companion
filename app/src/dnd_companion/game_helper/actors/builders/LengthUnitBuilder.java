package dnd_companion.game_helper.actors.builders;

import dnd_companion.game_helper.actors.entities.system.units.LengthUnitEntity;
import dnd_companion.game_helper.actors.models.Entity;
import dnd_companion.game_helper.actors.models.EntityBuilder;
import dnd_companion.local_storage.structure.system.units.LengthUnitData;

public class LengthUnitBuilder implements EntityBuilder 
{
	@Override public LengthUnitEntity buildNull() {
		return new LengthUnitEntity(null, null, null);
	}

	@Override public LengthUnitEntity buildByName(String name) {
		LengthUnitData data = (LengthUnitData) handler
				.retrieve(collections.length_units(), tools.toFileName(name))
				.result();
		return new LengthUnitEntity(
			data.name(),
			data.abbreviation(), 
			data.normalizing_factor()
		);
	}

	@Override public LengthUnitEntity deepCopy(Entity e) {
		LengthUnitEntity entity = (LengthUnitEntity) e;
		return new LengthUnitEntity(
			entity.name(),
			entity.abbreviation(),
			entity.normalizing_factor()
		);
	}
}
