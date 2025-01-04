package dnd_companion.common.metadata;

import java.util.Arrays;

import dnd_companion.common.tools.ToolBox;
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

public class CollectionsMetadata
{
	private final CollectionREF seed             = new CollectionREF(null, "seed");
	
	public final CollectionREF data              = new CollectionREF(seed, "data");
	
	public final CollectionREF system            = new CollectionREF(data, "system");
	public final CollectionREF items             = new CollectionREF(data, "items");
	public final CollectionREF campaigns         = new CollectionREF(data, "campaigns");
	
	public final CollectionREF units             = new CollectionREF(system, "units");
	public final CollectionREF damage_types      = new CollectionREF(system, "damage-types", DamageTypeData.class);
	public final CollectionREF dice_types        = new CollectionREF(system, "dice-types", DiceTypeData.class);
	public final CollectionREF action_types      = new CollectionREF(system, "action-types", ActionTypeData.class);
	
	public final CollectionREF currencies        = new CollectionREF(units, "currencies", CurrencyUnitData.class);
	public final CollectionREF length_units      = new CollectionREF(units, "length-units", LengthUnitData.class);
	public final CollectionREF weight_units      = new CollectionREF(units, "weight_units", WeightUnitData.class);
	public final CollectionREF time_units        = new CollectionREF(units, "time_units", TimeUnitData.class);
	
	public final CollectionREF ammunitions       = new CollectionREF(items, "ammunitions", AmmoData.class);
	public final CollectionREF item_tags         = new CollectionREF(items, "item-tags", ItemTagData.class);
	public final CollectionREF armors            = new CollectionREF(items, "armors", ArmorData.class);
	public final CollectionREF weapons           = new CollectionREF(items, "weapons", WeaponData.class);
	public final CollectionREF generics          = new CollectionREF(items, "generics", GenericItemData.class);
	
	public final CollectionREF armor_categories  = new CollectionREF(armors, "armor-categories", ArmorCategoryData.class);
	
	public final CollectionREF weapon_types      = new CollectionREF(weapons, "weapon-types", WeaponTypeData.class);
	public final CollectionREF weapon_categories = new CollectionREF(weapons, "weapon-categories", WeaponCategoryData.class);
	public final CollectionREF weapon_masteries  = new CollectionREF(weapons, "weapon-masteries", WeaponMasteryData.class);
	public final CollectionREF weapon_properties = new CollectionREF(weapons, "weapon-properties", WeaponPropertyData.class);
	
	public CollectionREF[] all() {
		CollectionsMetadata collections = new CollectionsMetadata();
		return Arrays.stream(CollectionsMetadata.class.getDeclaredFields())
				.map(f -> {
					try {return f.get(collections);} 
					catch (Exception e) {ToolBox.print(e); return null;}
				})
				.filter(c -> !c.equals(collections.seed))
				.toArray(CollectionREF[]::new);
	}
}
