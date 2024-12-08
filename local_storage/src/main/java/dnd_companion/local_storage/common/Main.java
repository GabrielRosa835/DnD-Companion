package dnd_companion.local_storage.common;

import dnd_companion.local_storage.storage.StorageBuilder;

public class Main
{
	private static StorageBuilder storage_builder = new StorageBuilder();
	
	public static void main (String args[])
	{
		ToolBox.print(storage_builder.initialize().message());
	}
}
