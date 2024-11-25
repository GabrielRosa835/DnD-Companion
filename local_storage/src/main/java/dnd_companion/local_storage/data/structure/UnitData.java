package dnd_companion.local_storage.data.structure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data.structure.templates.Data;

public record UnitData(String name, AtomicUnit[] options) implements Data {
	public static final String COLLECTION = "units";
	@JsonProperty("collection") public String collection() {return COLLECTION;}
	
	@JsonCreator
    public UnitData(
        @JsonProperty("name") String name,
        @JsonProperty("options") AtomicUnit[] options,
        @JsonProperty("collection") String collection) {
        this(name, options);
    }
}
