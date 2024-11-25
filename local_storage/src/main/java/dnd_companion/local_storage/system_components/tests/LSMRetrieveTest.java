package dnd_companion.local_storage.system_components.tests;

import dnd_companion.local_storage.data.structure.ArmorData;
import dnd_companion.local_storage.data.structure.components.ItemBasicProperties;
import dnd_companion.local_storage.data.structure.components.Price;
import dnd_companion.local_storage.data.structure.components.Weight;
import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.data.structure.templates.DataUtils;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.LocalStorageManager;

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
		DataKey key = DataUtils.create_data_key(data);
		this.result = LocalStorageManager.retrieve(key);
		return this;
	}
}
