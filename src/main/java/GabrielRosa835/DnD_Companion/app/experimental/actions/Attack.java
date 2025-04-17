package app.experimental.actions;

import app.rpg.strategies.checks.HasItemCheck;
import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.options.WeaponOption;
import app.strategies.Effect;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder (setterPrefix = "with")
public class Attack
{
   private CharacterActor source;
   private CharacterActor target;
   private WeaponOption weapon;
   private Effect effect;

   private HandlerChain<?, ?> handling;

   private boolean hasItem;
   public void setHasItem (Boolean hasItem) {
      this.hasItem = hasItem;
   }

   public void setup() {
      handling = HandlerChain
            .startWith(HasItemCheck.with(source, weapon))
            .saveResultIn(this::setHasItem)
            .compose()
   }
}
