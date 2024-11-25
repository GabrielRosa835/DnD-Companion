package dnd_companion.local_storage.data.structure.options;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public record ArmorCategory(String name) implements AtomicOption {
	public static final String GROUP = "armor-categories";
	public String group() {return GROUP;}
}
