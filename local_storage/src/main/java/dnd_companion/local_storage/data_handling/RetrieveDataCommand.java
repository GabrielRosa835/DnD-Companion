package dnd_companion.local_storage.data_handling;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.DataUtils;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class RetrieveDataCommand<T extends Data> extends Command
{
	private DataKey key;
	private ObjectReader reader;
	private Class<T> type;
	
	private T result;
	public T result() {return this.result;}
	
	public RetrieveDataCommand(DataKey key) {
		super();
		try {
			if(!key.class_name().equals(type.getName())) {
				throw new IllegalArgumentException("Command and key classes don't match");
			}
			this.key = key;	
			this.reader = new ObjectMapper().readerFor(Class.forName(key.class_name()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public RetrieveDataCommand<T> execute() {
		try {
			File file = new File(DataUtils.create_file_path(key));
			T data = reader.readValue(file);
			ToolBox.print("Options retrieved successfully: %s", key.toString());
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.result = null;
			this.status = false;
		}
		return this;
	}
}
