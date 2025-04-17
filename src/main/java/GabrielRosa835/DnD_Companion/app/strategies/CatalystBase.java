package app.strategies;

import lombok.*;

@AllArgsConstructor (access = AccessLevel.PROTECTED)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public abstract class CatalystBase
   implements Catalyst
{
   protected Effect effect;

   public Effect applyTo(Effect effect) {
      this.effect = effect;
      setup();
      execute();
      return assemble();
   }

   protected abstract void setup();
   protected abstract void execute();
   protected abstract Effect assemble();
}
