package dnd_companion.actors.entities.item.weapons;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityCentral;
import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityScheme;
import dnd_companion.common.BaseCollections;

public class WeaponCentral implements IEntityCentral
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
	public IEntityScheme scheme() {
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
	public IEntity retrieve(String entity_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
