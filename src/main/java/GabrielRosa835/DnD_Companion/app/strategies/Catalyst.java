package app.strategies;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface Catalyst
   extends
      Strategy<Effect, Effect>,
      UnaryOperator<Effect>
{
   Effect applyTo (Effect effect);

   default Effect execute (Effect effect) {
      return applyTo(effect);
   }
   default Effect apply (Effect effect) {
      return applyTo(effect);
   }
}
