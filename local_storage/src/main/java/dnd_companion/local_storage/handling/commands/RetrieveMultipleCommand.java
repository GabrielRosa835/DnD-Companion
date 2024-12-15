package dnd_companion.local_storage.handling.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.Data;

public class RetrieveMultipleCommand extends Command<Data[]> 
{
    private final String collection;
    private final Class<? extends Data> type;
    private String regex = ".*";
    private Integer limit = null;
    
    public RetrieveMultipleCommand filter(String regex) {
    	this.regex = regex;
    	return this.execute();
    }
    
    public RetrieveMultipleCommand limit(int limit) {
    	this.limit = limit;
    	return this.execute();
    }

    public RetrieveMultipleCommand(DataKey key) {
        this.collection = key.collection();
        this.type = key.type();
        this.message = "Failed to retrieve data collection: " + this.collection;
    }

    @Override
    public void code() throws IOException, DataNotFoundException {
        List<Data> data_list = new ArrayList<>();
        Pattern pattern = Pattern.compile(this.regex);
        try (Stream<Path> paths = Files.walk(Paths.get(ToolBox.create_file_path(this.collection)))) {
            List<String> file_names = paths
                .filter(Files::isRegularFile)
                .map(path -> ToolBox.exlude_file_extension(path.getFileName().toString()))
                .collect(Collectors.toList());
            if (this.limit != null && this.limit < file_names.size()) {
            	file_names = file_names.subList(0, this.limit);
            }
            for (String file_name : file_names) {
                Data data = new DataHandler()
                        .retrieve(new DataKey(this.collection, file_name, this.type))
                        .result();
                if (pattern.matcher(data.name()).matches()) {
                    data_list.add(data);
                }
            }
        }
        this.result = data_list.toArray(new Data[0]);
        this.message = "Data collection's retrieval was successful: " + this.collection;
    }
}