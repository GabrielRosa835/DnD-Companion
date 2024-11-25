package dnd_companion.local_storage.data_handling;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.data.structure.UnitData;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.DataUtils;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class RetrieveUnitsCommand extends Command
{
	private String unit_group;
	
	private AtomicUnit[] result;
	public AtomicUnit[] result() {return this.result;}
	
	private ObjectReader reader = new ObjectMapper().readerFor(UnitData.class);
	
	public RetrieveUnitsCommand(String unit_group) {
		this.unit_group = unit_group;
	}
	
	public RetrieveUnitsCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(new DataKey(UnitData.COLLECTION, unit_group)));
			UnitData data = reader.readValue(file);
			ToolBox.print("Units retrieved successfully: %s", unit_group);
			this.result = data.options();
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.result = null;
			this.status = false;
		}
		return this;
	}
}
