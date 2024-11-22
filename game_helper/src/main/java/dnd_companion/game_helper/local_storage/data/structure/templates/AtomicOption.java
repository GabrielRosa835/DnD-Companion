package dnd_companion.game_helper.local_storage.data.structure.templates;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface AtomicOption {
	public String name();
	public String group();
}
