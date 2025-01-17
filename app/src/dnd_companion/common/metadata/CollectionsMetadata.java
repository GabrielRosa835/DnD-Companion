package dnd_companion.common.metadata;

import java.util.Arrays;

import dnd_companion.archives.local_storage.structure.items.AmmoData;
import dnd_companion.archives.local_storage.structure.items.GenericItemData;
import dnd_companion.archives.local_storage.structure.items.ItemTagData;
import dnd_companion.archives.local_storage.structure.items.armors.ArmorCategoryData;
import dnd_companion.archives.local_storage.structure.items.armors.ArmorData;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponCategoryData;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponData;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponMasteryData;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponPropertyData;
import dnd_companion.archives.local_storage.structure.items.weapons.WeaponTypeData;
import dnd_companion.archives.local_storage.structure.system.ActionTypeData;
import dnd_companion.archives.local_storage.structure.system.DamageTypeData;
import dnd_companion.archives.local_storage.structure.system.DiceTypeData;
import dnd_companion.archives.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.archives.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.archives.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.archives.local_storage.structure.system.units.WeightUnitData;
import dnd_companion.common.tools.ToolBox;

public  class CollectionsMetadata
{
//================================================================================
	/*
	 * Dependencies' Injections
	 */
	private static ToolBox tools = new ToolBox();
//================================================================================
	
 // ===============================================================================
	/*
	 * Virtual seed for the hierarchy, not a real collection
	 * It's only reason to exist is such that data.parent() doesn't return null
	 */
	private CollectionREF seed = new CollectionREF(null, "seed");
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with SEED as parent
	 */
	private CollectionREF data = new CollectionREF(seed, "data");
	public  CollectionREF data() {return this.data;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with DATA as parent
	 */
	private CollectionREF system = new CollectionREF(data, "system");
	public  CollectionREF system() {return this.system;}
	
	private CollectionREF items = new CollectionREF(data, "items");
	public  CollectionREF items() {return this.items;}
	
	private CollectionREF campaigns = new CollectionREF(data, "campaigns");
	public  CollectionREF campaigns() {return this.campaigns;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with SYSTEM as parent
	 */
	private CollectionREF units = new CollectionREF(system, "units");
	public  CollectionREF units() {return this.units;}
	
	private CollectionREF damage_types = new CollectionREF(system, "damage-types", DamageTypeData.class);
	public  CollectionREF damage_types() {return this.damage_types;}
	
	private CollectionREF dice_types = new CollectionREF(system, "dice-types", DiceTypeData.class);
	public  CollectionREF dice_types() {return this.dice_types;}
	
	private CollectionREF action_types = new CollectionREF(system, "action-types", ActionTypeData.class);
	public  CollectionREF action_types() {return this.action_types;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with UNITS as parent
	 */
	private CollectionREF currencies = new CollectionREF(units, "currencies", CurrencyUnitData.class);
	public  CollectionREF currencies() {return this.currencies;}
	
	private CollectionREF length_units = new CollectionREF(units, "length-units", LengthUnitData.class);
	public  CollectionREF length_units() {return this.length_units;}
	
	private CollectionREF weight_units = new CollectionREF(units, "weight_units", WeightUnitData.class);
	public  CollectionREF weight_units() {return this.weight_units;}
	
	private CollectionREF time_units = new CollectionREF(units, "time_units", TimeUnitData.class);
	public  CollectionREF time_units() {return this.time_units;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with ITEMS as parent
	 */
	private CollectionREF ammunitions = new CollectionREF(items, "ammunitions", AmmoData.class);
	public  CollectionREF ammunitions() {return this.ammunitions;}
	
	private CollectionREF item_tags = new CollectionREF(items, "item-tags", ItemTagData.class);
	public  CollectionREF item_tags() {return this.item_tags;}
	
	private CollectionREF armors = new CollectionREF(items, "armors", ArmorData.class);
	public  CollectionREF armors() {return this.armors;}
	
	private CollectionREF weapons = new CollectionREF(items, "weapons", WeaponData.class);
	public  CollectionREF weapons() {return this.weapons;}
	
	private CollectionREF generic_items = new CollectionREF(items, "generics-items", GenericItemData.class);
	public  CollectionREF generic_items() {return this.generic_items;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with ARMORS as parent
	 */
	private CollectionREF armor_categories  = new CollectionREF(armors, "armor-categories", ArmorCategoryData.class);
	public  CollectionREF armor_categories() {return this.armor_categories;}
 // ===============================================================================
	
 // ===============================================================================
	/*
	 * Collections with WEAPONS as parent
	 */
	private CollectionREF weapon_types      = new CollectionREF(weapons, "weapon-types", WeaponTypeData.class);
	public  CollectionREF weapon_types() {return this.weapon_types;}
	
	private CollectionREF weapon_categories = new CollectionREF(weapons, "weapon-categories", WeaponCategoryData.class);
	public  CollectionREF weapon_categories() {return this.weapon_categories;}
	
	private CollectionREF weapon_masteries  = new CollectionREF(weapons, "weapon-masteries", WeaponMasteryData.class);
	public  CollectionREF weapon_masteries() {return this.weapon_masteries;}
	
	private CollectionREF weapon_properties = new CollectionREF(weapons, "weapon-properties", WeaponPropertyData.class);
	public  CollectionREF weapon_properties() {return this.weapon_properties;}
 // ===============================================================================	
	
 // ===============================================================================
	/*
	 * Method that returns all collections in a single array,
	 * used for getting a group of collections through filtering
	 */
	public  CollectionREF[] all() {
		return Arrays.stream(this.getClass().getDeclaredMethods())
				.map(m -> {
					try {return m.invoke(this);} 
					catch (Exception e) {tools.print(e); return null;}
				})
				.filter(c -> !c.equals(this.seed))
				.toArray(CollectionREF[]::new);
	}
 // ===============================================================================
}
