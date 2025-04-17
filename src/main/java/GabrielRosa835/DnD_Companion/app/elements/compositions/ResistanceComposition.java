package elements.compositions;

import behaviors.*;

import java.util.Set;

public class ResistanceComposition<Target extends Effectable<Target>>
{
   private Set<Catalyst<Effect<Target>>> elements;
   public Set<Catalyst<Effect<Target>>> get() {return elements;};

   public Effect<Target> applyAllTo (
         Effect<Target> effect
   ) {
      for (Catalyst<Effect<Target>> catalyst : elements) {
         effect = catalyst.applyTo(effect);
      }
      return effect;
   }
}
