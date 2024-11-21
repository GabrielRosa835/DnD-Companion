package dnd_companion.game_helper.local_storage.storage_builder;

import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class SBCreateDirectoryHierarquyCommand extends Command
{
	public SBCreateDirectoryHierarquyCommand execute() {
		try {
			StorageBuilder.create_directory("data");
			StorageBuilder.create_directory("data/armors");
			StorageBuilder.create_directory("data/weapons");
			StorageBuilder.create_directory("data/creatures");
			StorageBuilder.create_directory("data/campaings");
			StorageBuilder.create_directory("data/options");
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
