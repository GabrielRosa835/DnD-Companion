package dnd_companion.local_storage.structure.components.system.units.length;

import dnd_companion.local_storage.build.DataBuilder;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.templates.units.UnitComponent;

public class LengthUnitComponent implements UnitComponent
{		
	private String name;
	@Override public String name() {return this.name;}

	private String abbreviation; 
	@Override public String abbreviation() {return this.abbreviation;}

	private double normalizing_factor;
	@Override public double normalizing_factor() {return this.normalizing_factor;}

	public LengthUnitComponent(
		String name, 
		String abbreviation, 
		double normalizing_factor
	) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}

	@Override public LengthUnitComponent retrieve(String name) {
		return new DataBuilder.build(new DataHandler().retrieve(new DataKey()).result()).result();
	}
	
	@Override public LengthUnitComponent validate() {
		
	}
}