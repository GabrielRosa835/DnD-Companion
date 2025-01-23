package dnd_companion.common;

import dnd_companion.common.tools.ToolBox;
import dnd_companion.storage.archives.StorageBuilder;

public class Main
{
	public static void main(String[] args) {
		new StorageBuilder().initialize().message();
	}
}
