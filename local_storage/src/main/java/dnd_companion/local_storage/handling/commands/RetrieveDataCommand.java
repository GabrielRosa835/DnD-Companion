package dnd_companion.local_storage.handling.commands;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.structure.data.Data;

public class RetrieveDataCommand<T extends Data> extends Command
{
	private DataKey key;
	private ObjectReader reader;

	private T result;
	public T result() {return this.result;}

	public RetrieveDataCommand(DataKey key) {
		super();
		try {
			this.key = key;
			this.reader = new ObjectMapper().readerFor(Class.forName(key.type()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RetrieveDataCommand<T> execute() {
		try {
			File file = new File(ToolBox.create_file_path(key));
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
