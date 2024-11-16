package weapon;

import atomic.dice.Dice;
import atomic.distance.DistanceMeasure;
import items.ammo.Ammo;

public class Property {
	public Options option;
	
	public Property(Options option) {
		this.option = option;
	}

	public interface Options{
		public String name();
		
		public enum Fixed implements Options {
			FINESSE, HEAVY, LIGHT, LOADING, REACH, TWO_HANDED;
			public class AMMUNITION implements Options {
				public String name() {return this.getClass().getName();}
				
				public Ammo ammo;
				
				public AMMUNITION(Ammo ammo) {
					this.ammo = ammo;
				}
			}
			public class THROWN implements Options {
				public String name() {return this.getClass().getName();}
				
				public DistanceMeasure normal_range;
				public DistanceMeasure max_range;
				
				public THROWN(DistanceMeasure normal_range, DistanceMeasure max_range) {
					this.normal_range = normal_range;
					this.max_range = max_range;
				}
			}
			public class VERSATILE implements Options {
				public String name() {return this.getClass().getName();}
				
				public Dice dice;
				
				public VERSATILE(Dice dice) {
					this.dice = dice;
				}
			}
		}
		
		public class Custom implements Options {
			private String name;
			public String name() {return name;}
			
			public Custom(String name) {
				this.name = name.toUpperCase();
			}
		}
	}
}
