package dnd_companion.local_storage.structure.components.items.armors;

import dnd_companion.local_storage.structure.components.system.units.TimePeriod;

public class ArmorCategoryComponent
{
	private String name;
	public String name() {return this.name;}
	
	private String description;
	public String description() {return this.description;}
	
	private TimePeriod don_time;
	public TimePeriod don_time() {return don_time;}
	
	private TimePeriod doff_time;
	public TimePeriod doff_time() {return doff_time;}
	
	public ArmorCategoryComponent(String name, String description, TimePeriod don_time, TimePeriod doff_time) {
		super();
		this.name = name;
		this.description = description;
		this.don_time = don_time;
		this.doff_time = doff_time;
	}
	
	public ArmorCategoryComponent
}
