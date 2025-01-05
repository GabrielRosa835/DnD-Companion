package dnd_companion.game_helper.entities.components.system;

import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.game_helper.entities.models.Component;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.DiceTypeData;
import dnd_companion.local_storage.tools.DataKey;

public class DiceComponent implements Component
{		
	private int max_value;
	public int max_value() {return this.max_value;}
	
	public String name() {return String.format("d%d", this.max_value);}

	public int roll() {
		return (int) Math.ceil(Math.random()*this.max_value);
	}
	
	private DiceComponent(int max_value) {
		this.max_value = max_value;
	}
	private DiceComponent(DiceTypeData data) {
		this(data.max_value());
	}
	public DiceComponent(String name) {
		this ((DiceTypeData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().dice_types, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public DiceComponent copy() {
		return new DiceComponent(this.max_value);
	}
}
