package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.system.ActionTypeData;
import dnd_companion.local_storage.structure.data.system.DamageTypeData;
import dnd_companion.local_storage.structure.data.system.DiceData;

public class SystemOptionsSetupCommand extends Command<Boolean>
{
	private DataHandler data_handler = new DataHandler();
	
	@Override
	public SystemOptionsSetupCommand execute() {
		try {
			data_handler.save_multiple(
				new DamageTypeData("Acid"),
				new DamageTypeData("Bludgeoning"),
				new DamageTypeData("Cold"),
				new DamageTypeData("Fire"),
				new DamageTypeData("Force"),
				new DamageTypeData("Lightning"),
				new DamageTypeData("Necrotic"),
				new DamageTypeData("Piercing"),
				new DamageTypeData("Poison"),
				new DamageTypeData("Psychic"),
				new DamageTypeData("Radiant"),
				new DamageTypeData("Slashing"),
				new DamageTypeData("Thunder")
			);
			data_handler.save_multiple(
				new DiceData(4),
				new DiceData(6),
				new DiceData(8),
				new DiceData(10),
				new DiceData(12),
				new DiceData(20)
			);
			data_handler.save_multiple(
				new ActionTypeData("Action"),
				new ActionTypeData("Bonus Action"),
				new ActionTypeData("Reaction"),
				new ActionTypeData("Time Step")
			);
			this.status = true;
			this.result = true;
			this.message = "System options' setup was successful";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to setup system options";
		}
		return this;
	}
}
