package app.rpg.elements.options;

import app.rpg.elements.components.DamageComponent;
import app.rpg.elements.components.MeasureComponent;
import app.rpg.elements.compositions.WeaponPropertyComposition;
import app.rpg.models.Option;
import app.rpg.elements.options.types.Item;
import lombok.*;

@Builder (setterPrefix = "with")
public record WeaponOption(
      ItemTagOption[] tags,
      String description,
      MeasureComponent weight,
      MeasureComponent price,
      String name,

      WeaponPropertyComposition properties,
      WeaponCategoryOption category,
      WeaponMasteryOption mastery,
      WeaponTypeOption type,
      DamageComponent damage
) implements Option, Item
{

}
