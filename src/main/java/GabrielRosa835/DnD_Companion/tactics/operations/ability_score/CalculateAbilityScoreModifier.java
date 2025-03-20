package tactics.operations.ability_score;

import elements.components.groups.AbilityScoreGroup;
import lombok.AllArgsConstructor;
import tactics.Operation;

@AllArgsConstructor
public class CalculateAbilityScoreModifier implements
      Operation<Integer>
{
   private int abilityScoreValue;

   public static int with(int abilityScoreValue) {
      return new CalculateAbilityScoreModifier(abilityScoreValue).execute();
   }
   public static int with(AbilityScoreGroup group) {
      int abilityScoreValue = group.value();
      return new CalculateAbilityScoreModifier(abilityScoreValue).execute();
   }

   public Integer execute() {
      return (int) Math.floor(abilityScoreValue / 3) - 5;
   }
}
