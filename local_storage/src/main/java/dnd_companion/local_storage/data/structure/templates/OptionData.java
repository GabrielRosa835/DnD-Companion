package dnd_companion.local_storage.data.structure.templates;

public interface OptionData<T> extends Data
{
	public String name();
	public T[] options();
}
