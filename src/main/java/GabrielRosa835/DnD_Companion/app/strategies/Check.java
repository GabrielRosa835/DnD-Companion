package app.strategies;

import java.util.function.Predicate;

@FunctionalInterface
public interface Check
   extends
      Strategy<Void, Boolean>,
      Predicate<Void>
{
   boolean validate();

   default Boolean execute (Void unused) {
      return validate();
   }
   default boolean test (Void object) {
      return validate();
   }
}
