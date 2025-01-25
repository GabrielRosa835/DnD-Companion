package dnd_companion.archives.game_helper.actors.builders;

import dnd_companion.archives.game_helper.actors.entities.system.DamageTypeEntity;
import dnd_companion.entities.addons.models.EntityBuilder;
import dnd_companion.entities.rule_related.damage_types.DamageTypeData;

public class DamageTypeBuilder implements EntityBuilder
{
	@Override public DamageTypeEntity buildNull() {
		return new DamageTypeEntity(null);
	}

	@Override public DamageTypeEntity buildByName(String name) {
		DamageTypeData data = (DamageTypeData) handler
				.retrieve(collections.damage_types(), tools.toFileName(name))
				.result();
		return new DamageTypeEntity(
			data.name()
		);
	}

	@Override public DamageTypeEntity deepCopy(Entity e) {
		DamageTypeEntity entity = (DamageTypeEntity) e;
		return new DamageTypeEntity(entity.name());
	}

}
