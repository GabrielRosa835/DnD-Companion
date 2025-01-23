package dnd_companion.common.metadata;

import java.util.Arrays;

import dnd_companion.archives.local_storage.structure.items.ItemTagData;
import dnd_companion.archives.local_storage.structure.items.armors.ArmorData;
import dnd_companion.archives.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.archives.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.archives.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.archives.local_storage.structure.system.units.WeightUnitData;
import dnd_companion.common.design_patterns.Singleton;
import dnd_companion.entities.armor_related.ArmorCategoryData;
import dnd_companion.entities.item_related.GenericItemData;
import dnd_companion.entities.item_related.ammo.AmmoData;
import dnd_companion.entities.system_related.ActionTypeData;
import dnd_companion.entities.system_related.DamageTypeData;
import dnd_companion.entities.system_related.DiceTypeData;
import dnd_companion.entities.weapon_related.WeaponCategoryData;
import dnd_companion.entities.weapon_related.WeaponData;
import dnd_companion.entities.weapon_related.WeaponMasteryData;
import dnd_companion.entities.weapon_related.WeaponPropertyData;
import dnd_companion.entities.weapon_related.WeaponTypeData;

public class CollectionsMetadata implements Singleton
{
	private static CollectionsMetadata instance;
	
	private CollectionsMetadata() {}
	
	public static CollectionsMetadata get() {
		if(instance == null) {
			instance = new CollectionsMetadata();
		}
		return instance;
	}
	
	 // ===============================================================================
	private CollectionREF data = new CollectionREF(null, "data");
	public  CollectionREF data() {return instance.data;}
	 // ===============================================================================
	private CollectionREF system = new CollectionREF(data, "system");
	public  CollectionREF system() {return this.system;}
	
	private CollectionREF items = new CollectionREF(data, "items");
	public  CollectionREF items() {return this.items;}
	
	private CollectionREF campaigns = new CollectionREF(data, "campaigns");
	public  CollectionREF campaigns() {return this.campaigns;}
 // ===============================================================================
	private CollectionREF units = new CollectionREF(system, "units");
	public  CollectionREF units() {return this.units;}
	
	private CollectionREF damage_types = new CollectionREF(system, "damage-types");
	public  CollectionREF damage_types() {return this.damage_types;}
	
	private CollectionREF dice_types = new CollectionREF(system, "dice-types");
	public  CollectionREF dice_types() {return this.dice_types;}
	
	private CollectionREF action_types = new CollectionREF(system, "action-types");
	public  CollectionREF action_types() {return this.action_types;}
 // ===============================================================================
	private CollectionREF currencies = new CollectionREF(units, "currencies");
	public  CollectionREF currencies() {return this.currencies;}
	
	private CollectionREF length_units = new CollectionREF(units, "length-units");
	public  CollectionREF length_units() {return this.length_units;}
	
	private CollectionREF weight_units = new CollectionREF(units, "weight_units");
	public  CollectionREF weight_units() {return this.weight_units;}
	
	private CollectionREF time_units = new CollectionREF(units, "time_units");
	public  CollectionREF time_units() {return this.time_units;}
 // ===============================================================================
	private CollectionREF ammunitions = new CollectionREF(items, "ammunitions");
	public  CollectionREF ammunitions() {return this.ammunitions;}
	
	private CollectionREF item_tags = new CollectionREF(items, "item-tags");
	public  CollectionREF item_tags() {return this.item_tags;}
	
	private CollectionREF armors = new CollectionREF(items, "armors");
	public  CollectionREF armors() {return this.armors;}
	
	private CollectionREF weapons = new CollectionREF(items, "weapons");
	public  CollectionREF weapons() {return this.weapons;}
	
	private CollectionREF generic_items = new CollectionREF(items, "generics-items");
	public  CollectionREF generic_items() {return this.generic_items;}
 // ===============================================================================
	private CollectionREF armor_categories = new CollectionREF(armors, "armor-categories");
	public  CollectionREF armor_categories() {return this.armor_categories;}
 // ===============================================================================
	private CollectionREF weapon_types = new CollectionREF(weapons, "weapon-types");
	public  CollectionREF weapon_types() {return this.weapon_types;}
	
	private CollectionREF weapon_categories = new CollectionREF(weapons, "weapon-categories");
	public  CollectionREF weapon_categories() {return this.weapon_categories;}
	
	private CollectionREF weapon_masteries = new CollectionREF(weapons, "weapon-masteries");
	public  CollectionREF weapon_masteries() {return this.weapon_masteries;}
	
	private CollectionREF weapon_properties = new CollectionREF(weapons, "weapon-properties");
	public  CollectionREF weapon_properties() {return this.weapon_properties;}
 // ===============================================================================	
	/*
	 * Method that returns all collections in a single array,
	 * used for getting a group of collections through filtering
	 */
	public CollectionREF[] all() {
		return Arrays.asList(
				data(), 
				system(), campaigns(), items(), 
				units(), damage_types(), dice_types(), action_types(),
				currencies(), length_units(), weight_units(), time_units(),
				ammunitions(), item_tags(), armors(), weapons(), generic_items(),
				armor_categories(),
				weapon_types(), weapon_categories(), weapon_masteries(), weapon_properties()
				).toArray(CollectionREF[]::new);
	}
 // ===============================================================================
}
