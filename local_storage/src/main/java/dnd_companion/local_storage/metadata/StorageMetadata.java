package dnd_companion.local_storage.metadata;

import java.util.LinkedHashMap;

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
	
	private static final String data_directory = "data";
	private static final String system_directory = "system";
	private static final String campaigns_directory = "campaigns";
	private static final String items_directory = "items";
	private static final String units_directory = "units";

	static {
//		add(new DirRef(,));
		add(new DirRef(null, data_directory));

		add(new DirRef(data_directory, system_directory));
		add(new DirRef(data_directory, campaigns_directory));
		add(new DirRef(data_directory, items_directory));
		
		add(new DirRef(items_directory, new ArmorData().collection()));
		add(new DirRef(items_directory, new WeaponData().collection()));
		add(new DirRef(items_directory, new ItemTagData().collection()));
		add(new DirRef(items_directory, new AmmoData().collection()));
		
		add(new DirRef(new ArmorData().collection(), new ArmorCategoryData().collection()));
		
		add(new DirRef(new WeaponData().collection(), new WeaponCategoryData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponMasteryData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponPropertyData().collection()));
		add(new DirRef(new WeaponData().collection(), new WeaponTypeData().collection()));
		
		add(new DirRef(items_directory, new DamageTypeData().collection()));
		add(new DirRef(items_directory, new DiceData().collection()));
		add(new DirRef(items_directory, new ActionTypeData().collection()));
		add(new DirRef(items_directory, units_directory));
		
		add(new DirRef(units_directory, new CurrencyUnitData().collection()));
		add(new DirRef(units_directory, new LengthUnitData().collection()));
		add(new DirRef(units_directory, new WeightUnitData().collection()));
		add(new DirRef(units_directory, new TimeUnitData().collection()));
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
