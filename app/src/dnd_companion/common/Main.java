package dnd_companion.common;

import dnd_companion.archives.local_storage.storage.StorageBuilder;
import dnd_companion.common.tools.ToolBox;

public class Main
{
	public static void main(String[] args) {
		new StorageBuilder().initialize().message();
	}
}
