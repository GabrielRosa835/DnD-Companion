package items.weapon;

import atomic.damage.DamageManager;
import items.weapon.properties.WeaponPropertyManager;

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
