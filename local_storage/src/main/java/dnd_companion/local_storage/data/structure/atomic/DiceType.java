package dnd_companion.local_storage.data.structure.atomic;

public record DiceType(String type, int max_value) 
{
	public DiceType {
		type = type.toUpperCase();
	}
}
