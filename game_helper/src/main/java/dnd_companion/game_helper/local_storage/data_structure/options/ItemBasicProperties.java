package dnd_companion.game_helper.local_storage.data_structure.options;

public record ItemBasicProperties(
	String[] tags, 
	Price price, 
	Weight weight, 
	String description
) {}
