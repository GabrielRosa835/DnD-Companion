package items.weapon.properties;

import atomic.Element;
import atomic.dice.Dice;
import atomic.distance.DistanceMeasure;
import items.ammo.Ammo;

public interface WeaponProperty extends Element
{
	public enum Fixed implements WeaponProperty {
		FINESSE, HEAVY, LIGHT, LOADING, REACH, TWO_HANDED;
	}
	
	public class Ammunition implements WeaponProperty {
		public String name() {return "AMMUNITION";}
		
		private Ammo ammo;
		public Ammo ammo() {return this.ammo;}
		
		public Ammunition(Ammo ammo) {
			this.ammo = ammo;
		}
	}
	
	public class Range implements WeaponProperty {
		public String name() {return "RANGE";}
		
		private DistanceMeasure min_range;
		public DistanceMeasure min_range() {return this.min_range;}

		private DistanceMeasure max_range;
		public DistanceMeasure max_range() {return this.max_range;}
		
		public Range(DistanceMeasure min_range, DistanceMeasure max_range) {
			this.min_range = min_range;
			this.max_range = max_range;
		}
	}
	
	public class Thrown implements WeaponProperty {
		public String name() {return "THROWN";}
		
		private DistanceMeasure min_range;
		public DistanceMeasure min_range() {return this.min_range;}

		private DistanceMeasure max_range;
		public DistanceMeasure max_range() {return this.max_range;}
		
		public Thrown(DistanceMeasure min_range, DistanceMeasure max_range) {
			this.min_range = min_range;
			this.max_range = max_range;
		}
	}
	
	public class Versatile implements WeaponProperty {
		public String name() {return "VERSATILE";}
		
		private Dice versatile_dice;
		public Dice versatile_dice() {return this.versatile_dice;}
		
		public Versatile(Dice versatile_dice) {
			this.versatile_dice = versatile_dice;
		}
	}
}
