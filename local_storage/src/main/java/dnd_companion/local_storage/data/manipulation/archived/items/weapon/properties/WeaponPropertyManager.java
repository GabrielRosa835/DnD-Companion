package dnd_companion.local_storage.data.manipulation.archived.items.weapon.properties;

import java.util.Collection;

import dnd_companion.local_storage.data.manipulation.AbstractManager;
import dnd_companion.local_storage.data.manipulation.archived.items.weapon.properties.WeaponPropertyGroup.WeaponPropertyType;

public class WeaponPropertyManager extends AbstractManager<WeaponPropertyType, WeaponPropertyGroup, WeaponPropertyManager>
{
	public WeaponPropertyManager() {
		super();
	}
	public WeaponPropertyManager(Collection<WeaponPropertyGroup> weapon_property_groups) {
		super(weapon_property_groups);
	}
	public WeaponPropertyManager(WeaponPropertyManager weapon_property_cluster) {
		super(weapon_property_cluster);
	}
	
	@Override
	protected void add_element(WeaponPropertyGroup group) {
		this.mapping.put(group.type(), group);
	}
	
	@Override
	protected void remove_element(WeaponPropertyGroup group) {
		this.mapping.remove(group.type());
	}
}
