package behaviors.catalysts;

import behaviors.CatalystModel;
import behaviors.effects.DamageEffect;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor (access = AccessLevel.PROTECTED)
public class DamageMultiplyCatalyst extends CatalystModel<DamageEffect>
{
   public final double factor;

   private int newDamage;

   @Override protected void setup () {
      newDamage = target.damage;
   }
   @Override protected void execute () {
      newDamage = (int) (newDamage * factor);
   }
   @Override protected DamageEffect assemble () {
      return new DamageEffect(newDamage);
   }
}
