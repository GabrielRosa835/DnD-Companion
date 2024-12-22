package dnd_companion.local_storage.models.components;

import dnd_companion.local_storage.models.data.Data;

public interface Component
{
	public Component copy();
	public Data retrieve(String name);
}
