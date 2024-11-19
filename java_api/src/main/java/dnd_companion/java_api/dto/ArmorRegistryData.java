package dnd_companion.java_api.dto;

public record ArmorRegistryData(
	String name,
	Object[] tags, 
	double price, 
	double weight, 
	String description
){}
