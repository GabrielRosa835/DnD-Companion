package app.strategies;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface Effect
	extends
      Strategy<Object, Object>,
      UnaryOperator<Object>
{
   Object applyTo (Object object);

   default Object execute (Object object) {return applyTo(object);}
   default Object apply (Object object) {
      return applyTo(object);
   }
}