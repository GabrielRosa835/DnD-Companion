package dnd_companion.storage.archives.handling;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.CommandManager;
import dnd_companion.common.metadata.CollectionREF;

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
	public RetrieveCommand retrieve(CollectionREF collection, String file_name) {
		return new RetrieveCommand(new DataKey(collection, file_name)).execute();
	}
	public RetrieveCommand retrieve(DataKey key) {
		return new RetrieveCommand(key).execute();
	}
	public RetrieveMultipleCommand retrieve_multiple (CollectionREF collection) {
		return new RetrieveMultipleCommand(collection).execute();
	}
}
