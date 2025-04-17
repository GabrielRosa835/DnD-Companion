package app.storage;

import app.storage.local.Folder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@FieldDefaults (level = AccessLevel.PACKAGE)
@Accessors
@Getter
public class CoreCollections
      extends CoreContainers
{
   static Folder data = Folder.create("data", null);

   static Folder system = Folder.create("system", data);
   static Folder items = Folder.create("items", data);

   static Folder units = Folder.create("units", system);

   static {
      damageTypes = Folder.upgrade(damageTypes, system);
      diceTypes = Folder.upgrade(diceTypes, system);
      actionTypes = Folder.upgrade(actionTypes, system);

      unitTypes = Folder.upgradeWithName(unitTypes, units, "types");
      currencyUnits = Folder.upgradeWithName(currencyUnits, units, "currency");
      lengthUnits = Folder.upgradeWithName(lengthUnits, units, "length");
      weightUnits = Folder.upgradeWithName(weightUnits, units, "weight");
      timeUnits = Folder.upgradeWithName(timeUnits, units, "time");

      itemTags = Folder.upgradeWithName(itemTags, items, "tags");
      genericItems = Folder.upgradeWithName(genericItems, items, "generic");
      ammunition = Folder.upgrade(ammunition, items);

      var armorsFolder = Folder.upgrade(armors, items);
      armors = armorsFolder;
      armorCategories = Folder.upgradeWithName(armorCategories, armorsFolder, "categories");

      var weaponsFolder = Folder.upgrade(weapons, items);
      weapons = weaponsFolder;
      weaponTypes = Folder.upgradeWithName(weaponTypes, weaponsFolder, "types");
      weaponCategories = Folder.upgradeWithName(weaponCategories, weaponsFolder, "categories");
      weaponMasteries = Folder.upgradeWithName(weaponMasteries, weaponsFolder, "masteries");
      weaponProperties = Folder.upgradeWithName(weaponProperties, weaponsFolder, "properties");

      declaredClass = CoreFolders.class;
   }
}
