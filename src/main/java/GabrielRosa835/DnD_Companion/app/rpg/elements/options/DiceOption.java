package app.rpg.elements.options;

import app.rpg.models.Option;

public record DiceOption (
      String name,
      int maxValue,
      double average
) implements Option
{
   public DiceOption (int maxValue) {
      this("D" + maxValue, maxValue, (double) (maxValue + 1) / 2);
   }
}
