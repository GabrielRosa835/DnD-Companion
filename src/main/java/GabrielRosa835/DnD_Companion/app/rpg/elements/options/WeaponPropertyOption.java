package app.rpg.elements.options;

import app.rpg.models.Option;

public record WeaponPropertyOption (
      String name
) implements Option
{
   // AMMUNITION (Ammo, Range), FINESSE, HEAVY,
   // LIGHT, LOADING, REACH, THROWN (Range),
   // TWO-HANDED, VERSATILE (dice)
}
