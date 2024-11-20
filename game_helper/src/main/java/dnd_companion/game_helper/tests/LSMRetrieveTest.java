package dnd_companion.game_helper.tests;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataKey;
import dnd_companion.game_helper.local_storage.LocalStorageManager;
import dnd_companion.game_helper.local_storage.data_structure.data.ArmorData;
import dnd_companion.game_helper.local_storage.data_structure.options.ItemBasicProperties;
import dnd_companion.game_helper.local_storage.data_structure.options.Price;
import dnd_companion.game_helper.local_storage.data_structure.options.Weight;
import dnd_companion.game_helper.utils.DataBuilder;

public class LSMRetrieveTest extends CommandTest 
{	
	private Data data = new ArmorData (
		"armors",
		"Plate Armor",
		new ItemBasicProperties(
			new String[]{"Armor", "Wearable"},
			new Price(1500, "GP"),
			new Weight(65, "LBS"),
			"Description :)"
		),
		"HEAVY",
		18,
		15,
		true
	);
	
	public LSMRetrieveTest execute() {
		DataKey key = DataBuilder.create_data_key(data);
		this.result = LocalStorageManager.retrieve(key);
		return this;
	}
}
