package behaviors;

import lombok.*;

@AllArgsConstructor (access = AccessLevel.PROTECTED)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public abstract class CatalystModel<IEffect extends Effect<?>>
{
   protected IEffect target;

   public IEffect applyTo(IEffect element) {
      this.target = element;
      setup();
      execute();
      return assemble();
   };

   protected abstract void setup();
   protected abstract void execute();
   protected abstract IEffect assemble();
}
