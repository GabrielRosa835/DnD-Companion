package dnd_companion.game_helper.local_storage.storage_build;

import dnd_companion.game_helper.local_storage.system_components.CollectionClassMap;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class CreateDirectoryHierarquyCommand extends Command
{
	public CreateDirectoryHierarquyCommand execute() {
		try {
			StorageBuilder.create_directory("data");
			for (String collection : CollectionClassMap.mapping().keySet()) {
				StorageBuilder.create_directory(String.format("data/%s", collection));
			}
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
