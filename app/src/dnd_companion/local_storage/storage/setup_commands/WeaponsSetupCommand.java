package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.common.Command;
import dnd_companion.common.metadata.UnitMetadata;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.structure.items.weapons.WeaponData;
import dnd_companion.local_storage.structure.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.structure.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.structure.items.weapons.WeaponTypeData;

public class WeaponsSetupCommand extends Command<Boolean>
{
	public WeaponsSetupCommand() {
		this.message = "Failed to setup weapons";
	}
	
	@Override public void code() {
		DataHandler data_handler = new DataHandler();
		data_handler.save_multiple(
			new WeaponCategoryData("Simple"),
			new WeaponCategoryData("Martial")
		);
		data_handler.save_multiple(
			new WeaponTypeData("Melee"),
			new WeaponTypeData("Ranged")
		);
		data_handler.save_multiple(
			new WeaponMasteryData("Cleave", "If you hit a creature with a melee attack roll using this weapon, you can make a melee attack roll with the weapon against a second creature within 5 feet of the first that is also within your reach. On a hit, the second creature takes the weapon's damage, but don't add your ability modifier to that damage unless that modifier is negative. You can make this extra attack only once per turn."),
			new WeaponMasteryData("Graze", "If your attack roll with this weapon misses a creature, you can deal damage to that creature equal to the ability modifier you used to make the attack roll. This damage is the same type dealt by the weapon, and the damage can be increased only by increasing the ability modifier."),
			new WeaponMasteryData("Nick", "When you make the extra attack of the Light property, you can make it as part of the Attack action instead of as a Bonus Action. You can make this extra attack only once per turn."),
			new WeaponMasteryData("Push", "If you hit a creature with this weapon, you can push the creature up to 10 feet straight away from yourself if it is Large or smaller."),
			new WeaponMasteryData("Sap", "If you hit a creature with this weapon, that creature has Disadvantage on its next attack roll before the start of your next turn."),
			new WeaponMasteryData("Slow", "If you hit a creature with this weapon and deal damage to it, you can reduce its Speed by 10 feet until the start of your next turn. If the creature is hit more than once by weapons that have this property, the Speed reduction doesn't exceed 10 feet."),
			new WeaponMasteryData("Topple", "If you hit a creature with this weapon, you can force the creature to make a Constitution saving throw (DC 8 plus the ability modifier used to make the attack roll and your Proficiency Bonus). On a failed save, the creature has the Prone condition."),
			new WeaponMasteryData("Vex", "If you hit a creature with this weapon and deal damage to the creature, you have Advantage on your next attack roll against that creature before the end of your next turn.")
		);
		data_handler.save_multiple(
			new WeaponPropertyData("Ammunition", "You can use a weapon that has the Ammunition property to make a ranged attack only if you have ammunition to fire from it. The type of ammunition required is specified with the weapon's range. Each attack expends one piece of ammunition. Drawing the ammunition is part of the attack (you need a free hand to load a one-handed weapon). After a fight, you can spend 1 minute to recover half the ammunition (round down) you used in the fight; the rest is lost."),
			new WeaponPropertyData("Finesse", "When making an attack with a Finesse weapon, use your choice of your Strength or Dexterity modifier for the attack and damage rolls. You must use the same modifier for both rolls."),
			new WeaponPropertyData("Heavy", "You have Disadvantage on attack rolls with a Heavy weapon if it's a Melee weapon and your Strength score isn't at least 13 or if it's a Ranged weapon and your Dexterity score isn't at least 13."),
			new WeaponPropertyData("Light", "When you take the Attack action on your turn and attack with a Light weapon, you can make one extra attack as a Bonus Action later on the same turn. That extra attack must be made with a different Light weapon, and you don't add your ability modifier to the extra attack's damage unless that modifier is negative. For example, you can attack with a Shortsword in one hand and a Dagger in the other using the Attack action and a Bonus Action, but you don't add your Strength or Dexterity modifier to the damage roll of the Bonus Action unless that modifier is negative."),
			new WeaponPropertyData("Loading", "You can fire only one piece of ammunition from a Loading weapon when you use an action, a Bonus Action, or a Reaction to fire it, regardless of the number of attacks you can normally make."),
			new WeaponPropertyData("Range", "A Range weapon has a range in parentheses after the Ammunition or Thrown property. The range lists two numbers. The first is the weapon's normal range in feet, and the second is the weapon's long range. When attacking a target beyond normal range, you have Disadvantage on the attack roll. You can't attack a target beyond the long range."),
			new WeaponPropertyData("Reach", "A Reach weapon adds 5 feet to your reach when you attack with it, as well as when determining your reach for Opportunity Attacks with it."),
			new WeaponPropertyData("Thrown", "If a weapon has the Thrown property, you can throw the weapon to make a ranged attack, and you can draw that weapon as part of the attack. If the weapon is a Melee weapon, use the same ability modifier for the attack and damage rolls that you use for a melee attack with that weapon."),
			new WeaponPropertyData("Two-Handed", "A Two-Handed weapon requires two hands when you attack with it."),
			new WeaponPropertyData("Versatile", "A Versatile weapon can be used with one or two hands. A damage value in parentheses appears with the property. The weapon deals that damage when used with two hands to make a melee attack.")
		);
		data_handler.save_multiple(
			new WeaponData(
				"Shortsword",
				10, UnitMetadata.get_name("gp"),
				2, UnitMetadata.get_name("lbs"),
				new String[] {"Weapon"},
				"No description",
				"Martial",
				"Melee",
				1, "d6", "Slashing",
				new String[] {"Finesse", "Light"},
				"Vex",
				1, 1, UnitMetadata.get_name("sq"),
				null),
			new WeaponData(
				"Longsword",
				15, UnitMetadata.get_name("gp"),
				3, UnitMetadata.get_name("lbs"),
				new String[] {"Weapon"},
				"No description",
				"Martial",
				"Melee",
				1, "d8", "Slashing",
				new String[] {"Versatile"},
				"Sap",
				1, 1, UnitMetadata.get_name("sq"),
				"d10"),
			new WeaponData(
				"Greatsword",
				50, UnitMetadata.get_name("gp"),
				6, UnitMetadata.get_name("lbs"),
				new String[] {"Weapon"},
				"No description",
				"Martial",
				"Melee",
				2, "d6", "Slashing",
				new String[] {"Heavy", "Two-Handed"},
				"Graze",
				1, 1, UnitMetadata.get_name("sq"),
				null)
		);
		this.result = true;
		this.message = "Weapons' setup was successful";
	}
}
