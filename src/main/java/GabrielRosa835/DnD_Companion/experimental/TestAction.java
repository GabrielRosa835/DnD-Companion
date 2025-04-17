package experimental;

import behaviors.Effect;
import behaviors.Effectable;

import java.util.List;
import java.util.function.Predicate;

public class TestAction<T extends Effectable<T>> extends AbstractAction<Character, T>
{

   TestAction (Effect<T> effect, List<Predicate<Character>> sourceTests, List<Predicate<T>> targetTests) {
      super(effect, sourceTests, targetTests);
   }
}
