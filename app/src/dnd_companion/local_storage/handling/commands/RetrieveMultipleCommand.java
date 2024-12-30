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

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DataNotFoundException;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.tools.DataKey;

public class RetrieveMultipleCommand extends Command<Data[]> 
{
	private final CollectionREF collection;
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

    public RetrieveMultipleCommand(CollectionREF collection) {
        this.collection = collection;
        this.message = "Failed to retrieve data collection: " + this.collection;
    }

    @Override
    public void code() throws IOException, DataNotFoundException {
        List<Data> data_list = new ArrayList<Data>();
        Pattern pattern = Pattern.compile(this.regex);
        try (Stream<Path> paths = Files.walk(Paths.get(this.collection.path()))) {
            List<String> file_names = paths
                .filter(Files::isRegularFile)
                .map(path -> {
                	String name = path.getFileName().toString();
                	int dot_index = name.lastIndexOf('.');
            		String name_without_extension = (dot_index == -1) ? name : name.substring(0, dot_index);
            		return name_without_extension; 
                })
                .collect(Collectors.toList());
            if (this.limit != null && this.limit < file_names.size()) {
            	file_names = file_names.subList(0, this.limit);
            }
            for (String file_name : file_names) {
                Data data = new DataHandler()
                        .retrieve(new DataKey(this.collection, file_name))
                        .result();
                if (pattern.matcher(data.file_name().replace(".json", "")).matches()) {
                    data_list.add(data);
                }
            }
        }
        this.result = data_list.toArray(Data[]::new);
        this.message = "All data was sucessfully retrieved: " + this.collection;
    }
}