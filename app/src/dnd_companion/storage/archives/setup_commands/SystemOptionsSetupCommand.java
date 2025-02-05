package dnd_companion.storage.archives.setup_commands;

import dnd_companion.actors.entities.rules.action_types.ActionTypeData;
import dnd_companion.actors.entities.rules.damage_types.DamageTypeData;
import dnd_companion.actors.entities.system.DiceTypeData;

public class SystemOptionsSetupCommand
{
	public void code() {

			new DamageTypeData("Acid");
			new DamageTypeData("Bludgeoning");
			new DamageTypeData("Cold");
			new DamageTypeData("Fire");
			new DamageTypeData("Force");
			new DamageTypeData("Lightning");
			new DamageTypeData("Necrotic");
			new DamageTypeData("Piercing");
			new DamageTypeData("Poison");
			new DamageTypeData("Psychic");
			new DamageTypeData("Radiant");
			new DamageTypeData("Slashing");
			new DamageTypeData("Thunder");

			new DiceTypeData(4);
			new DiceTypeData(6);
			new DiceTypeData(8);
			new DiceTypeData(10);
			new DiceTypeData(12);
			new DiceTypeData(20);

			new ActionTypeData("Action");
			new ActionTypeData("Bonus Action");
			new ActionTypeData("Reaction");
			new ActionTypeData("Time Step");
	}
}
