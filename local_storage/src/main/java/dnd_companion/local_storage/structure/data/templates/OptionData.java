package dnd_companion.local_storage.structure.data.templates;

public interface OptionData<T> extends Data
{
	@Override
	public String collection();
	@Override
	public String file_name();
	public T[] options();
}
