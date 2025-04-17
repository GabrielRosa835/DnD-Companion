package experimental.actions;

import behaviors.Effect;
import elements.components.Health;
import elements.entities.character.Character;
import elements.entities.items.weapon.Weapon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AttackAction
{
   private Weapon weapon;
   private Effect<Health> effect;

   private List<Predicate<Character>> tests =
         Arrays.asList(
               character -> character.belongings().contains(weapon)
         );


   public boolean check(Character source) {
      return tests.stream().allMatch(t -> t.test(source));
   }
}
