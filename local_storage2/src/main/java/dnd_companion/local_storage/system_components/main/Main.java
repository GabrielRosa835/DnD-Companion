package dnd_companion.local_storage.system_components.main;

import dnd_companion.local_storage.storage_build.StorageBuilder;

public class Main
{
	public static void main (String args[])
	{
		StorageBuilder.setup_directory_hierarquy();
		StorageBuilder.setup_options();
		StorageBuilder.setup_armors();
	}
}
