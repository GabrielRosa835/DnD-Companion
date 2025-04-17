package app.rpg.strategies.operations;

import app.strategies.Operation;
import app.rpg.elements.compositions.CatalystComposition;
import app.strategies.Catalyst;
import app.strategies.Effect;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@Builder (setterPrefix = "with")
public class ApplyAllCatalystsOperation
   implements Operation<Effect>
{
   private Effect effect;

   @Singular
   private Collection<Catalyst> catalysts;

   public static Effect with(Effect effect, CatalystComposition catalystComposition) {
      var catalysts = catalystComposition.content();
      return new ApplyAllCatalystsOperation(effect, catalysts).process();
   }
   public static Effect with(Effect effect, Catalyst[] catalystArray) {
      var catalysts = Arrays.asList(catalystArray);
      return new ApplyAllCatalystsOperation(effect, catalysts).process();
   }
   public static Effect with(Effect effect, Collection<Catalyst> catalysts) {
      return new ApplyAllCatalystsOperation(effect, catalysts).process();
   }

   @Override public Effect process () {
      for (Catalyst catalyst : catalysts) {
         try {
            effect = catalyst.applyTo(effect);
         } catch (Exception e) {

         }
      }
      return effect;
   }
}
