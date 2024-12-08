package dnd_companion.local_storage.handling;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.command.CommandManager;
import dnd_companion.local_storage.handling.commands.RetrieveDataCommand;
import dnd_companion.local_storage.handling.commands.SaveCommand;
import dnd_companion.local_storage.handling.commands.SaveMultipleCommand;
import dnd_companion.local_storage.structure.data.Data;

public class DataHandler extends CommandManager
{
	public DataHandler save(Data data) {
		this.last_command = new SaveCommand(data).execute(); 
		return this;
	}
	public DataHandler save_multiple(Data... data_collection) {
		this.last_command = new SaveMultipleCommand(data_collection).execute();
		return this;
	}
	public <T extends Data> DataHandler retrieve(DataKey key) {
		this.last_command = new RetrieveDataCommand<T>(key).execute();
		return this;
	}
}
