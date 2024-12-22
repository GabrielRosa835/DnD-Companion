package dnd_companion.local_storage.structure.components.system;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.models.components.Component;
import dnd_companion.local_storage.structure.data.system.DamageTypeData;

public class DamageTypeComponent implements Component	 
{
	private String name;
	public String name() {return this.name;}
	
	private DamageTypeComponent(DamageTypeData data) {
		this.name = data.name();
	}
	public DamageTypeComponent() {
		this.name = null;
	}
	public DamageTypeComponent(String name) {
		this(new DamageTypeComponent().retrieve(name));
	}
	
	@Override public DamageTypeData retrieve(String name) {
		return (DamageTypeData) new DataHandler()
				.retrieve(new DataKey(new DamageTypeData().collection(), name, DamageTypeData.class))
				.result();
	}
	@Override public DamageTypeComponent copy() {
		DamageTypeComponent temp = new DamageTypeComponent();
		temp.name = this.name;
		return temp;
	}
}
