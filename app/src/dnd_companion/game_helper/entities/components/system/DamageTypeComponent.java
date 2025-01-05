package dnd_companion.game_helper.entities.components.system;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.DamageTypeData;
import dnd_companion.local_storage.tools.DataKey;

public class DamageTypeComponent implements Component	 
{
	private String name;
	public String name() {return this.name;}
	
	private DamageTypeComponent(DamageTypeData data) {
		this.name = data.name();
	}
	private DamageTypeComponent() {
		this.name = null; 
	}
	public DamageTypeComponent(String name) {
		this ((DamageTypeData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().damage_types, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public DamageTypeComponent copy() {
		DamageTypeComponent temp = new DamageTypeComponent();
		temp.name = this.name;
		return temp;
	}
}
