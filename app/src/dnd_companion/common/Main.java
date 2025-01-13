package dnd_companion.common;

import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.storage.StorageBuilder;

public class Main
{
	public static void main(String[] args) {
		new ToolBox().print(new StorageBuilder().initialize().message());
	}
}
