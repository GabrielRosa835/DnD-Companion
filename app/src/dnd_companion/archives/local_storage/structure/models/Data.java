package dnd_companion.archives.local_storage.structure.models;

import java.io.File;

import dnd_companion.archives.local_storage.tools.ValidateDataCommand;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;

public interface Data
{
	final CollectionsMetadata collections = new CollectionsMetadata();
	final ToolBox tools = new ToolBox();
	
	public CollectionREF collection();
	public String file_name();
	
	public static ValidateDataCommand validate(Data data) {
		return new ValidateDataCommand(data).execute();
	}
	public static String path(Data data) {
		return data.collection().path() + File.separator + data.file_name();
	}
}
