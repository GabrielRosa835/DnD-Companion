package dnd_companion.game_helper.local_storage.data.manipulation.items.weapon.properties;

public class WeaponPropertyGroup extends Group<WeaponProperty> 
{
	public String name() {return this.element.name();}
	
	private WeaponPropertyType type;
	public WeaponPropertyType type() {return this.type;} 
	
	public enum WeaponPropertyType {
		AMMUNITION, FINESSE, HEAVY, LIGHT, LOADING, RANGE, REACH, THROWN, TWO_HANDED, VERSATILE;
	}
}
