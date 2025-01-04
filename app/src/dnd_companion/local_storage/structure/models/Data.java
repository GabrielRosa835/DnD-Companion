package dnd_companion.local_storage.structure.models;

import java.io.File;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.tools.ValidateDataCommand;

public interface Data
{
	public CollectionREF collection();
	public String file_name();
	
	public static ValidateDataCommand validate(Data data) {
		return new ValidateDataCommand(data).execute();
	}
	public static String path(Data data) {
		return data.collection().path() + File.separator + data.file_name();
	}
}
