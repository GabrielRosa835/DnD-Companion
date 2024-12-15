package dnd_companion.local_storage.structure.components.items.armors;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.system.units.TimeComponent;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;

public class ArmorCategoryComponent
{
	private String name;
	public String name() {return this.name;}
	
	private TimeComponent don_time;
	public TimeComponent don_time() {return don_time;}
	
	private TimeComponent doff_time;
	public TimeComponent doff_time() {return doff_time;}
	
	public ArmorCategoryComponent(String category_name) {
		ArmorCategoryData data = (ArmorCategoryData) new DataHandler()
				.retrieve(new DataKey(new ArmorCategoryData().collection(), name, ArmorCategoryData.class))
				.result();
		this.name = data.name();
		this.don_time = new TimeComponent(data.don_time(), data.doff_time_unit());
		this.doff_time = new TimeComponent(data.doff_time(), data.doff_time_unit());	
	}
}
