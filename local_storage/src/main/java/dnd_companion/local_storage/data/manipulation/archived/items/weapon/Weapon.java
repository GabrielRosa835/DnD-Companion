package dnd_companion.local_storage.data.manipulation.archived.items.weapon;

import dnd_companion.local_storage.data.manipulation.archived.atomic.damage.DamageManager;
import dnd_companion.local_storage.data.manipulation.archived.items.weapon.properties.WeaponPropertyManager;

public interface Weapon 
{
	public WeaponCategory category();
	public WeaponExtent extent();
	public DamageManager damage();
	public WeaponPropertyManager martial_properties();
	public Mastery mastery();
	
	public enum WeaponCategory {
		SIMPLE, MARTIAL;
	}
	public enum Mastery {
		CLEAVE, GRAZE, NICK, PUSH, SAP, SLOW, TOPPLE, VEX;
	}
}
