package dnd_companion.local_storage.structure.data.system;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record DiceData (
	int max_value
) implements Data {
	@Override public String collection() {return "dice-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name());}
	
	public String name() {return String.format("D%d", this.max_value);}
	
	public DiceData() {
		this(0);
	}
	public DiceData validate() {
		return (DiceData) new DataValidator().validate(this).result();
	}
}
