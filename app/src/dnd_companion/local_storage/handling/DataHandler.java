package dnd_companion.local_storage.handling;

import dnd_companion.common.CommandManager;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.handling.commands.RetrieveCommand;
import dnd_companion.local_storage.handling.commands.RetrieveMultipleCommand;
import dnd_companion.local_storage.handling.commands.SaveCommand;
import dnd_companion.local_storage.handling.commands.SaveMultipleCommand;
import dnd_companion.local_storage.handling.commands.UpdateCommand;
import dnd_companion.local_storage.handling.commands.UpdateMultipleCommand;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.tools.DataKey;

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
	public RetrieveMultipleCommand retrieve_multiple (CollectionREF collection) {
		return new RetrieveMultipleCommand(collection).execute();
	}
}
