package dnd_companion.local_storage.handling;

import dnd_companion.local_storage.common.CommandManager;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.commands.*;
import dnd_companion.local_storage.structure.data.Data;

public class DataHandler extends CommandManager
{
	public SaveCommand save(Data data) {
		return new SaveCommand(data).execute(); 
	}
	public SaveMultipleCommand save_multiple(Data... data_collection) {
		return new SaveMultipleCommand(data_collection).execute();
	}
	public UpdateCommand update(Data data) {
		return new UpdateCommand(data).execute(); 
	}
	public UpdateMultipleCommand update_multiple(Data... data_collection) {
		return new UpdateMultipleCommand(data_collection).execute();
	}
	public RetrieveCommand retrieve(DataKey key) {
		return new RetrieveCommand(key).execute();
	}
	public RetrieveMultipleCommand retrieve_multiple (String collection, Class<? extends Data> type) {
		return new RetrieveMultipleCommand(collection, type).execute();
	}
}
