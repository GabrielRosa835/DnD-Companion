package app.experimental.actions;

import app.strategies.Check;
import app.rpg.models.Actor;
import app.rpg.models.Option;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public abstract class ActionModel
   implements Action
{
   protected Option option;
   @Singular ("source")
   protected Collection<Actor<?>> sources;
   @Singular ("source")
   protected Collection<Actor<?>> targets;
   @Singular ("check")
   protected Collection<Check> filterChecks;

   @Override public Optional<Boolean> perform() {
      Collection<Option> options = filter();
      option = choose(options);
      act();
      return resolve();
   }

   protected abstract void prepare();
   protected abstract Collection<Option> filter();
   protected abstract Option choose(Collection<Option> options);
   protected abstract void act();
   protected abstract Optional<Boolean> resolve();
}
