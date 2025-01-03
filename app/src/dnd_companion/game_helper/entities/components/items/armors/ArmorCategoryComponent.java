package dnd_companion.game_helper.entities.components.items.armors;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.data.items.armors.ArmorCategoryData;
import dnd_companion.game_helper.entities.elements.system.units.TimeStep;
import dnd_companion.local_storage.structure.models.components.Component;

public class ArmorCategoryComponent implements Component
{
	private String name;
	public String name() {return this.name;}
	
	private TimeStep don_time;
	public TimeStep don_time() {return this.don_time;}
	
	private TimeStep doff_time;
	public TimeStep doff_time() {return this.doff_time;}
	
	private ArmorCategoryComponent(String name, TimeStep don_time, TimeStep doff_time) {
		this.name = name;
		this.don_time = don_time;
		this.doff_time = doff_time;
	}
	private ArmorCategoryComponent(
		String name,
		double don_time_value, String don_time_unit,
		double doff_time_value, String doff_time_unit
	) {
		this(
			name,
			new TimeStep(don_time_value, don_time_unit),
			new TimeStep(doff_time_value, doff_time_unit)
		);
	}
	private ArmorCategoryComponent(ArmorCategoryData data) {
		this(
			data.name(),
			data.don_time_value(),
			data.don_time_unit(),
			data.doff_time_value(),
			data.doff_time_unit()
		);
	}
	public ArmorCategoryComponent() {
		this(null, null, null);
	}
	public ArmorCategoryComponent(String name) {
		ArmorCategoryData data = (ArmorCategoryData) new DataHandler()
				.retrieve(new DataKey(new ArmorCategoryData().collection(), name, ArmorCategoryData.class))
				.result();
		this.name = data.name();
		this.don_time = new TimeStep(data.don_time(), data.doff_time_unit());
		this.doff_time = new TimeStep(data.doff_time(), data.doff_time_unit());	
	}
	
	@Override public ArmorCategoryData retrieve(String name) {
		return (ArmorCategoryData) new DataHandler()
				.retrieve(new DataKey(name, ArmorCategoryData.class))
				.result();
	}
}
