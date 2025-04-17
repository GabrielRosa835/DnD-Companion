package app.rpg.strategies.checks;

import app.strategies.Check;
import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.compositions.ItemComposition;
import app.rpg.elements.options.types.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HasItemCheck
   implements Check
{
   private ItemComposition belongings;
   private Item item;

   public static HasItemCheck with (CharacterActor character, Item item) {
      var belongings = character.belongings();
      return new HasItemCheck(belongings, item);
   }
   public static HasItemCheck with (ItemComposition belongings, Item item) {
      return new HasItemCheck(belongings, item);
   }

   @Override public boolean validate () {
      return belongings.content().containsKey(item);
   }
}
