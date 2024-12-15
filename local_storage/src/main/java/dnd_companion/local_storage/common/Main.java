package dnd_companion.local_storage.common;

import dnd_companion.local_storage.storage.StorageBuilder;

public class Main
{
	public static void main (String args[])
	{
		ToolBox.print(new StorageBuilder().initialize().message());
	}
}
