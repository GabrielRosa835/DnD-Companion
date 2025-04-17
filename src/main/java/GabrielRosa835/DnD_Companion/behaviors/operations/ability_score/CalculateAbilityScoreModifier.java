<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/ability_score/CalculateAbilityScoreModifier.java
package GabrielRosa835.dnd_companion.app.tactics.operations.ability_score;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
========
package behaviors.operations.ability_score;

import elements.components.groups.AbilityScoreGroup;
import lombok.AllArgsConstructor;
import behaviors.Operation;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/ability_score/CalculateAbilityScoreModifier.java

@AllArgsConstructor
public class CalculateAbilityScoreModifier implements Operation<Integer>
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
