package dnd_companion.local_storage.handling.commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.structure.data.Data;

public class SaveMultipleCommand extends Command<Data[]>
{
	private Data[] data_collection;
	
	public SaveMultipleCommand(Data[] data_collection) {
		this.data_collection = data_collection;
	}

	public SaveMultipleCommand execute() {
		try {
			for (Data data : data_collection) {
				new SaveCommand(data).execute().status();
			}			
			this.message = "All data was saved/updated successfully";
			this.status = true;
			this.result = data_collection;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.message = "Something went wrong while saving the data collection";
			this.status = false;
			this.result = null;
		}
		return this;
	}
}
