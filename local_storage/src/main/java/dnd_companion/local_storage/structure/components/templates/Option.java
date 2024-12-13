package dnd_companion.local_storage.structure.components.templates;

public interface Option<O extends Option<O>> extends Retrievable<O>
{
	public O validate();
}
