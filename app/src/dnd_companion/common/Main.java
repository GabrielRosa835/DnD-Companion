package dnd_companion.common;

import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.storage.StorageBuilder;

public class Main
{
	public static void main(String[] args) {
		ToolBox.print(new StorageBuilder().create_directory(Collections.armors.path()).message());
	}
}
