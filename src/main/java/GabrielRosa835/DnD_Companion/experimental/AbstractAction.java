package experimental;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import behaviors.Effect;
import behaviors.Effectable;

import java.util.*;
import java.util.function.Predicate;

@Builder (setterPrefix = "with")
@Getter
@Accessors (fluent = true)
public abstract class AbstractAction<S, T extends Effectable<T>>
{
   private Effect<T> effect;

   @Builder.ObtainVia(field = "sourceTest")
   private List<Predicate<S>> sourceTests = new ArrayList<>();
   @Builder.ObtainVia(field = "targetTest")
   private List<Predicate<T>> targetTests = new ArrayList<>();

   public boolean checkSource(S source) {
      return sourceTests.stream()
            .allMatch(p -> p.test(source));
   }
   public boolean checkTarget(T target) {
      return targetTests.stream()
            .allMatch(p -> p.test(target));
   }

   public Map<S, Boolean> checkSources(List<S> sources) {
      Map<S, Boolean> results = new HashMap<>();
      sources.forEach(s -> results.put(s, checkSource(s)));
      return results;
   }
   public Map<T, Boolean> checkTargets(List<T> targets) {
      Map<T, Boolean> results = new HashMap<>();
      targets.forEach(t -> results.put(t, checkTarget(t)));
      return results;
   }
}
