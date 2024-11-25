package dnd_companion.local_storage.data.manipulation.archived.weapon;

import dnd.characters.system.HasFixedOptions;
import dnd_companion.local_storage.data.manipulation.length.DistanceMeasure;

public class Extent {
	public Type type;
	public DistanceMeasure normal_range;
	public DistanceMeasure max_range;
	
	public Extent(Type type, DistanceMeasure normal_range, DistanceMeasure max_range) {
		this.type = type;
		switch(type) {
		case Type.Fixed.MELEE:
			this.normal_range = new DistanceMeasure(dnd.characters.system.AtomType.Fixed.SQUARES, 1);
			this.max_range = new DistanceMeasure(dnd.characters.system.AtomType.Fixed.SQUARES, 1);
		default:
			this.normal_range = normal_range;
			this.max_range = max_range;
		}
	}
	
	public interface Type extends HasFixedOptions {
		public String name();
		
		public enum Fixed implements Type {MELEE, RANGED}
		
		public class Custom implements Type 
		{
			private String name;
			public String name() {return name;}
			
			public Custom(String name) {
				this.name = name.toUpperCase();
			}
		}
	}

}
