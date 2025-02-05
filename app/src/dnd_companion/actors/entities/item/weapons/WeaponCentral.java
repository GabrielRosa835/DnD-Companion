package dnd_companion.actors.entities.item.weapons;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.actors.models.EntityFactory;
import dnd_companion.actors.models.EntityScheme;
import dnd_companion.common.BaseCollections;

public class WeaponCentral implements EntityCentral
{
	@Override public WeaponBuilder builder() {
		return new WeaponBuilder();
	}

	@Override
	public EntityFactory factory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityScheme scheme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseCollections collection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String path(String entity_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity retrieve(String entity_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
