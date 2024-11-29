package dnd_companion.local_storage.storage_build;

import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.ToolBox;

public class CreateDirectoryHierarquyCommand extends Command
{
	@Override
	public CreateDirectoryHierarquyCommand execute() {
		try {
			for (StorageMetadata.DirRef directory : StorageMetadata.directory_hierarquy.values()) {
				StorageBuilder.create_directory(directory.path());
			}
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
