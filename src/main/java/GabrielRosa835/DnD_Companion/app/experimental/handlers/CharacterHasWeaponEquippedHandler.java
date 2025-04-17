package app.experimental.handlers;

import app.strategies.Operation;
import app.experimental.actions.HandlerBase;
import app.rpg.elements.actors.CharacterActor;

public class CharacterHasWeaponEquippedHandler
   extends HandlerBase<CharacterActor>
{
   @Override public CharacterActor handle (Operation<CharacterActor> operation) {
      try {
         CharacterActor character = operation.process();
      } catch (Exception e) {
         handleNext(operation);
      }

      // character.equipment().heldItems().containsValue(null)
      if ()
         return target;
      else
         return handleNext(target);
   }
}
