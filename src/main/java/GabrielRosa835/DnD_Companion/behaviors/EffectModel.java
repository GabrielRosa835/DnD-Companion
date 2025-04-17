package behaviors;

import lombok.*;

@AllArgsConstructor (access = AccessLevel.PROTECTED)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public abstract class EffectModel<Target extends Effectable<Target>> implements Effect<Target>
{
   protected Target target;

   public Target applyTo(Target element) {
      this.target = element;
      setup();
      execute();
      return assemble();
   };

   protected abstract void setup();
   protected abstract void execute();
   protected abstract Target assemble();
}