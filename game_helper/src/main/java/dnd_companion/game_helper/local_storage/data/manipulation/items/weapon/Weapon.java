package dnd_companion.game_helper.local_storage.data.manipulation.items.weapon;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.damage.DamageManager;
import dnd_companion.game_helper.local_storage.data.manipulation.items.weapon.properties.WeaponPropertyManager;

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
