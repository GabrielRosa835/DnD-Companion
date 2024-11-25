package dnd_companion.local_storage.data.structure.templates;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public interface Data 
{
	public String name();
	public String collection();
}
