package dnd_companion.local_storage.structure.components.templates;

public interface Retrievable<T extends Retrievable<T>> 
{
	public T retrieve(String name);
}
