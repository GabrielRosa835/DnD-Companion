package app.rpg.elements.options;

import app.rpg.models.Option;

public record ActionTypeOption (
      String name
) implements Option
{
   // FULL_ACTION, BONUS_ACTION, REACTION, INSTANT, SPECIAL
}
