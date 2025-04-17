package app.rpg.strategies.catalysts;

import app.strategies.CatalystBase;
import app.rpg.strategies.effects.DamageEffect;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class DamageMultiplyCatalyst
   extends CatalystBase
{
   @With public final double factor;

   private DamageEffect target;
   private int newDamage;

   @Override protected void setup () {
      target = (DamageEffect) effect;
      newDamage = target.damage;
   }
   @Override protected void execute () {
      newDamage = (int) (newDamage * factor);
   }
   @Override protected DamageEffect assemble () {
      return new DamageEffect(newDamage);
   }
}
