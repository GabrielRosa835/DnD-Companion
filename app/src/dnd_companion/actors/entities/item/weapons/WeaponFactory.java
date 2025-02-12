package dnd_companion.actors.entities.item.weapons;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntity;

public class WeaponFactory implements EntityFactory
{
	@Override public List<IEntity> dataList() {
		 return Arrays.asList(null);
	}
	@Override public IEntity defaultData() {
		return new DefaultWeapon();
	}
	
}
