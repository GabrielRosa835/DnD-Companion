package dnd_companion.common.metadata;

import java.util.Arrays;

import dnd_companion.common.ToolBox;
import dnd_companion.local_storage.structure.items.AmmoData;
import dnd_companion.local_storage.structure.items.GenericItemData;
import dnd_companion.local_storage.structure.items.ItemTagData;
import dnd_companion.local_storage.structure.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.items.armors.ArmorData;
import dnd_companion.local_storage.structure.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.structure.items.weapons.WeaponData;
import dnd_companion.local_storage.structure.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.structure.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.structure.items.weapons.WeaponTypeData;
import dnd_companion.local_storage.structure.system.ActionTypeData;
import dnd_companion.local_storage.structure.system.DamageTypeData;
import dnd_companion.local_storage.structure.system.DiceTypeData;
import dnd_companion.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.local_storage.structure.system.units.WeightUnitData;

public abstract class Collections
{
	public static final CollectionREF data              = new CollectionREF(null, "data");
	
	public static final CollectionREF system            = new CollectionREF(data, "system");
	public static final CollectionREF items             = new CollectionREF(data, "items");
	public static final CollectionREF campaigns         = new CollectionREF(data, "campaigns");
	
	public static final CollectionREF units             = new CollectionREF(system, "units");
	public static final CollectionREF damage_types      = new CollectionREF(system, "damage-types", DamageTypeData.class);
	public static final CollectionREF dice_types        = new CollectionREF(system, "dice-types", DiceTypeData.class);
	public static final CollectionREF action_types      = new CollectionREF(system, "action-types", ActionTypeData.class);
	
	public static final CollectionREF currencies        = new CollectionREF(units, "currencies", CurrencyUnitData.class);
	public static final CollectionREF length_units      = new CollectionREF(units, "length-units", LengthUnitData.class);
	public static final CollectionREF weight_units      = new CollectionREF(units, "weight_units", WeightUnitData.class);
	public static final CollectionREF time_units        = new CollectionREF(units, "time_units", TimeUnitData.class);
	
	public static final CollectionREF ammunitions       = new CollectionREF(items, "ammunitions", AmmoData.class);
	public static final CollectionREF item_tags         = new CollectionREF(items, "item-tags", ItemTagData.class);
	public static final CollectionREF armors            = new CollectionREF(items, "armors", ArmorData.class);
	public static final CollectionREF weapons           = new CollectionREF(items, "weapons", WeaponData.class);
	public static final CollectionREF generics          = new CollectionREF(items, "generics", GenericItemData.class);
	
	public static final CollectionREF armor_categories  = new CollectionREF(armors, "armor-categories", ArmorCategoryData.class);
	
	public static final CollectionREF weapon_types      = new CollectionREF(weapons, "weapon-types", WeaponTypeData.class);
	public static final CollectionREF weapon_categories = new CollectionREF(weapons, "weapon-categories", WeaponCategoryData.class);
	public static final CollectionREF weapon_masteries  = new CollectionREF(weapons, "weapon-masteries", WeaponMasteryData.class);
	public static final CollectionREF weapon_properties = new CollectionREF(weapons, "weapon-properties", WeaponPropertyData.class);
	
	public static CollectionREF[] all() {		
		return Arrays.stream(Collections.class.getDeclaredFields()).map(f -> {
			try {return f.get(null);} 
			catch (Exception e) {ToolBox.print(e); return null;}
		}).toArray(CollectionREF[]::new);
	}
}
