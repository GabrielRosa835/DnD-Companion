package items.weapon.properties;

import atomic.Group;

public class WeaponPropertyGroup extends Group<WeaponProperty> 
{
	public String name() {return this.element.name();}
	
	private WeaponPropertyType type;
	public WeaponPropertyType type() {return this.type;} 
	
	public enum WeaponPropertyType {
		AMMUNITION, FINESSE, HEAVY, LIGHT, LOADING, RANGE, REACH, THROWN, TWO_HANDED, VERSATILE;
	}
}
