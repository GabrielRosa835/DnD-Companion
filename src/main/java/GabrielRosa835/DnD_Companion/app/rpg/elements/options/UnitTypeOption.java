package app.rpg.elements.options;

import app.rpg.models.Option;

public record UnitTypeOption (
      String name
) implements Option
{
   // DISTANCE, WEIGHT, TIME, CURRENCY
}
