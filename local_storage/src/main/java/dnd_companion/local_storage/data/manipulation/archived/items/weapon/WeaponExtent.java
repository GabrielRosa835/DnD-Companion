package dnd_companion.local_storage.data.manipulation.archived.items.weapon;

import dnd_companion.local_storage.data.manipulation.archived.items.weapon.properties.WeaponPropertyManager;
import dnd_companion.local_storage.data.manipulation.length.DistanceMeasure;

public interface WeaponExtent 
{
	public class Melee 
	{
		private WeaponPropertyManager weapon_properties;
		
		private DistanceMeasure reach;
		public DistanceMeasure reach() {return this.reach;}
		
		private DistanceMeasure min_thrown_range;
		public DistanceMeasure min_thrown_range() {
			
		}
		
		private DistanceMeasure max_thrown_range;
		public DistanceMeasure max_thrown_range() {return this.max_thrown_range;}
		
		public Melee() {
			this.reach = new DistanceMeasure(LengthUnit.Standard.SQUARES, 1);
			this.min_thrown_range = new DistanceMeasure(LengthUnit.Standard.SQUARES, 0);
			this.max_thrown_range = new DistanceMeasure(LengthUnit.Standard.SQUARES, 0);
		}
		
		public Melee(WeaponPropertyManager weapon_properties) {
			if (weapon_properties.contains("REACH")) {				
				this.reach = new DistanceMeasure(LengthUnit.Standard.SQUARES, 2);
			} else {
				this.reach = new DistanceMeasure(LengthUnit.Standard.SQUARES, 1);
			}
			
			if (weapon_properties.contains("THROWN")) {
				this.min_thrown_range = weapon_properties.values().get().max;
			}
		}
	}
	public class Ranged 
	{
		private WeaponPropertyManager weapon_properties;
		
		private DistanceMeasure min_range;
		public DistanceMeasure min_range() {return this.min_range;}
		
		private DistanceMeasure max_range;
		public DistanceMeasure max_range() {return this.max_range;}
		
	}
}
