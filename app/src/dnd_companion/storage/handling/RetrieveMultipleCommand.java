package dnd_companion.storage.handling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityCentral;
import dnd_companion.common.ToolBox;
import dnd_companion.common.design_patterns.Command;

public class RetrieveMultipleCommand implements Command
{
	private EntityCentral central;
    private String regex = ".*";
    private int limit = 0;

    private List<Entity> result;
    public List<Entity> result() {return result;}

    public RetrieveMultipleCommand filter(String regex) {
    	this.regex = regex;
    	return this;
    }
    public RetrieveMultipleCommand limit(int limit) {
    	this.limit = limit;
    	return this;
    }

    public RetrieveMultipleCommand(EntityCentral central) {
        this.central = central;
    }

    public RetrieveMultipleCommand execute() {
        List<Entity> entity_list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        try (Stream<Path> paths = Files.walk(Paths.get(central.collection().path()))) {
            List<String> file_names = paths
                .filter(Files::isRegularFile)
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
            List<String> limited_file_names = limitFilter(limit, file_names);
            for (String file_name : limited_file_names) {
                Entity entity = DataHandler.retrieve(central, file_name);
                if (pattern.matcher(entity.name()).matches()) {
                    entity_list.add(entity);
                }
            }
        } catch (IOException e) {
        	ToolBox.exceptionHandler(e);
        }
        this.result = entity_list;
        return this;
    }

    private List<String> limitFilter(int limit, List<String> list) {
    	int size = list.size();
    	if (limit == 0 || size == 0
			|| Integer.compareUnsigned(limit, size) <= 0
		) {
    		return list;
        }
    	if (limit > 0) {
			list = list.subList(0, limit);
    	}
    	if (limit < 0) {
    		list = list.subList(size-limit, size);
    	}
    	return list;
    }
}