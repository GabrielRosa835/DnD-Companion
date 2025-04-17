package app.strategies;

import lombok.*;

@AllArgsConstructor (access = AccessLevel.PROTECTED)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public abstract class EffectBase
   implements Effect
{
   protected Object object;

   public Object applyTo(Object object) {
      this.object = object;
      setup();
      execute();
      return assemble();
   }

   protected abstract void setup();
   protected abstract void execute();
   protected abstract Object assemble();
}