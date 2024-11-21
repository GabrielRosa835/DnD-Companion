package dnd_companion.game_helper.local_storage.data_builder;

import dnd_companion.game_helper.local_storage.data.structure.WeaponData;
import dnd_companion.game_helper.local_storage.manager.LocalStorageManager;
import dnd_companion.game_helper.utils.Command;

public class DBCreateWeaponCommand extends Command
{
	private WeaponData data;

	public DBCreateWeaponCommand(WeaponData data) {
		this.data = data;
	}
	
	public DBCreateWeaponCommand execute() {
		try {
			LocalStorageManager.save(data);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return this;
	}
}
