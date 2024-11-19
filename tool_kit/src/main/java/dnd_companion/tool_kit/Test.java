package dnd_companion.tool_kit;

import dnd_companion.tool_kit.data_management.ArmorData;
import dnd_companion.tool_kit.data_management.DataManager;
import dnd_companion.tool_kit.data_management.simple.Price;
import dnd_companion.tool_kit.data_management.simple.Weight;

public class Test 
{
	public static void main(String args[]) {
		
		ArmorData test_armor_data = new ArmorData(
			"Plate Armor",
			new Weight(Weight.WeightUnits.LBS, 65),
			new Price(Price.PriceUnits.GP, 1500),
			ArmorData.ArmorCategory.HEAVY,
			18,
			15,
			true
		);
		DataManager.save(test_armor_data);
	}
}
