package experimental;

import lombok.Builder;
import behaviors.Effectable;

import java.util.List;

@Builder (setterPrefix = "add")
public class TestMediator<S, T extends Effectable<T>>
{
   private List<S> sources;
   private List<T> targets;
   private TestAction<T> action;

   public void execute() {
      if (sources == null || sources.isEmpty()) return;
      if (targets == null || targets.isEmpty()) return;
      if (action == null) return;
      var targetsCheck = action.checkTargets(targets);

      targets.stream()
            .filter(targetsCheck::get)
            .forEach(t -> t.applyEffect(action.effect()));
   }
}
