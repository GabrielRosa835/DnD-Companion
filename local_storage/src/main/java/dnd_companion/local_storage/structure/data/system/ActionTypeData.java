package dnd_companion.local_storage.structure.data.system;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.models.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record ActionTypeData (
	String name
) implements Data {
	@Override public String collection() {return "action-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ActionTypeData() {
		this(null);
	}
	public ActionTypeData validate() {
		return (ActionTypeData) new DataValidator().validate(this).result();
	}
}
