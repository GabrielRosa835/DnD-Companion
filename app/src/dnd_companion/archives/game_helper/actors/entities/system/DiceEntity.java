package dnd_companion.archives.game_helper.actors.entities.system;

import dnd_companion.archives.game_helper.actors.models.Component;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.entities.system_related.DiceTypeData;
import dnd_companion.storage.archives.handling.DataHandler;

public class DiceEntity implements Component
{		
	private int max_value;
	public int max_value() {return this.max_value;}
	
	public String name() {return String.format("d%d", this.max_value);}

	public int roll() {
		return (int) Math.ceil(Math.random()*this.max_value);
	}
	
	private DiceEntity(int max_value) {
		this.max_value = max_value;
	}
	private DiceEntity(DiceTypeData data) {
		this(data.max_value());
	}
	public DiceEntity(String name) {
		this ((DiceTypeData) new DataHandler()
				.retrieve(new DataKey(
						new CollectionsMetadata().dice_types, 
						ToolBox.to_snake_case(name).concat(".json")))
				.result());
	}
	
	@Override public DiceEntity copy() {
		return new DiceEntity(this.max_value);
	}
}
