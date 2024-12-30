package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.common.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.ItemTagData;

public class ItemsSetupCommand extends Command<Boolean>
{
	public ItemsSetupCommand() {
		this.message = "Failed to setup items";
	}
	
	@Override public void code() {
		DataHandler data_handler = new DataHandler();
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
		this.result = true;
		this.message = "Items' setup was successful";
	}
}
