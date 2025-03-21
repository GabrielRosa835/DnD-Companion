package GabrielRosa835.dnd_companion.app.tactics.operations.ability_score;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;

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
