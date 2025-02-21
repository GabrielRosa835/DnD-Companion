package dnd_companion.storage.assembling;

import dnd_companion.common.BaseCollections;

public class SetupFileSystemCommand 
{
	public void execute() {
		for (BaseCollections collection : BaseCollections.mapping().keySet()) {
			StorageAssembler.createDirectory(collection.path());
		}
	}
}
