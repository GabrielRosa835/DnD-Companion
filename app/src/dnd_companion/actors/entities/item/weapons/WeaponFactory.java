package dnd_companion.actors.entities.item.weapons;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityFactory;

public class WeaponFactory implements EntityFactory
{
	@Override public List<Entity> dataList() {
		 return Arrays.asList(null);
	}
	@Override public Entity defaultData() {
		return new DefaultWeapon();
	}
	
}
