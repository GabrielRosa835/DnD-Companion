package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.tags.ItemTagData;

public class ItemsSetupCommand extends Command<Boolean>
{
	private DataHandler data_handler = new DataHandler();
	
	@Override
	public ItemsSetupCommand execute() {
		try {
			data_handler.save_multiple(
				new ItemTagData("Armor"),
				new ItemTagData("Weapon"),
				new ItemTagData("Magical"),
				new ItemTagData("Food and Drink"),
				new ItemTagData("Ammunition"),
				new ItemTagData("Adventuring Gear"),
				new ItemTagData("Tool"),
				new ItemTagData("Instrument")
			);
			this.status = true;
			this.result = true;
			this.message = "Items' setup was successful";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to setup items";
		}
		return this;
	}
}
