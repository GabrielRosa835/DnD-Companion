package app.rpg.elements.options;

import app.rpg.models.Option;

public record WeaponMasteryOption (
      String name,
      String description
) implements Option
{
   // CLEAVE, GRAZE, NICK, PUSH, SAP, SLOW, TOPPLE, VEX
}
