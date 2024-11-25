package dnd_companion.local_storage.data.structure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.data.structure.templates.Data;

public record OptionData(String name, AtomicOption[] options) implements Data {
	public static final String COLLECTION = "options";
	@JsonProperty("collection") public String collection() {return COLLECTION;}
	
	@JsonCreator
    public OptionData(
        @JsonProperty("name") String name,
        @JsonProperty("options") AtomicOption[] options,
        @JsonProperty("collection") String collection) {
        this(name, options);
    }
}
