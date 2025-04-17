package app.rpg.elements.options;

import app.rpg.models.Option;

public record WeaponTypeOption (
      String name
) implements Option
{
   // MELEE, RANGED
}
