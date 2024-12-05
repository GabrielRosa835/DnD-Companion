package dnd_companion.local_storage.common.main;

import dnd_companion.local_storage.storage.StorageBuilder;

public class Main
{
	public static void main (String args[])
	{
		StorageBuilder.setup_directory_hierarquy();
		StorageBuilder.setup_options();
		StorageBuilder.setup_armors();
	}
}
