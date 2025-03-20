package elements.components.groups;

import elements.entities.system.Measure;
import elements.entities.items.weapon.WeaponProperty;
import elements.entities.items.Ammunition;
import fundamentals.Dice;

import java.util.List;

public class WeaponPropertyGroup
{
   private List<WeaponProperty> properties;

   private Ammunition ammunitionType;
   private Measure normalRange;
   private Measure longRange;
   private Dice versatileDamageDice;
}
