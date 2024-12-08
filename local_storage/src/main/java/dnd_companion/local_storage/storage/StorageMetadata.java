package dnd_companion.local_storage.storage;

import java.util.LinkedHashMap;

import dnd_companion.local_storage.structure.data.CampaignData;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.structure.data.ItemData;
import dnd_companion.local_storage.structure.data.SystemData;
import dnd_companion.local_storage.structure.data.UnitData;
import dnd_companion.local_storage.structure.data.items.ammunition.AmmoData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;
import dnd_companion.local_storage.structure.data.items.tags.ItemTagData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponTypeData;
import dnd_companion.local_storage.structure.data.system.ActionTypeData;
import dnd_companion.local_storage.structure.data.system.DamageTypeData;
import dnd_companion.local_storage.structure.data.system.DiceData;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.TimeUnitData;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

public abstract class StorageMetadata
{
	public static final LinkedHashMap<String, DirRef> directory_hierarquy = new LinkedHashMap<>();

	private static void add(DirRef dir_ref) {
		directory_hierarquy.put(dir_ref.dir_name(), dir_ref);
	}

	static {
//		add(new DirRef(,));
		add(new DirRef(null, Data.file));

		add(new DirRef(Data.file, SystemData.file));
		add(new DirRef(Data.file, CampaignData.file));
		add(new DirRef(Data.file, ItemData.file));
		
		add(new DirRef(ItemData.file, new ArmorData().collection()));
		add(new DirRef(ItemData.file, new WeaponData().collection()));
		add(new DirRef(ItemData.file, new ItemTagData().collection()));
		add(new DirRef(ItemData.file, new AmmoData().collection()));
		
		add(new DirRef(new ArmorData().collection(), new ArmorCategoryData().collection()));
		
		add(new DirRef(new WeaponData().collection(), new WeaponCategoryData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponMasteryData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponPropertyData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponTypeData().collection()));
		
		add(new DirRef(SystemData.file, new DamageTypeData().collection()));
		add(new DirRef(SystemData.file, new DiceData().collection()));
		add(new DirRef(SystemData.file, new ActionTypeData().collection()));
		add(new DirRef(SystemData.file, UnitData.file));
		
		add(new DirRef(UnitData.file, new CurrencyUnitData().collection()));
		add(new DirRef(UnitData.file, new LengthUnitData().collection()));
		add(new DirRef(UnitData.file, new WeightUnitData().collection()));
		add(new DirRef(UnitData.file, new TimeUnitData().collection()));
	}

	public record DirRef(String parent_dir, String dir_name) {
		public String path(){
			DirRef current = this;
			String path = current.dir_name;
			String parent_dir = path;

			while (parent_dir != "data") {
				current = StorageMetadata.directory_hierarquy.get(parent_dir);
				parent_dir = current.parent_dir();
				path = String.format("%s\\%s", parent_dir, path);
			}
			return path;
		}
	}
}
