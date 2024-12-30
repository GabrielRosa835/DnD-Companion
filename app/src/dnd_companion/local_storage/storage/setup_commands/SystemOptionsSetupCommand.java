package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.common.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.system.ActionTypeData;
import dnd_companion.local_storage.structure.system.DamageTypeData;
import dnd_companion.local_storage.structure.system.DiceTypeData;

public class SystemOptionsSetupCommand extends Command<Boolean>
{
	public SystemOptionsSetupCommand() {
		this.message = "Failed to setup system options";
	}
	
	@Override public void code() {
		DataHandler data_handler = new DataHandler();
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
			new DiceTypeData(4),
			new DiceTypeData(6),
			new DiceTypeData(8),
			new DiceTypeData(10),
			new DiceTypeData(12),
			new DiceTypeData(20)
		);
		data_handler.save_multiple(
			new ActionTypeData("Action"),
			new ActionTypeData("Bonus Action"),
			new ActionTypeData("Reaction"),
			new ActionTypeData("Time Step")
		);
		this.result = true;
		this.message = "System options' setup was successful";
	}
}
