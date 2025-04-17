package app.rpg.strategies.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.components.AbilityScoreComponent;
import app.rpg.elements.compositions.AbilityScoreComposition;
import app.rpg.elements.options.AbilityScoreOption;
import lombok.AllArgsConstructor;
import app.strategies.Operation;

@AllArgsConstructor
public class CalculateAbilityScoreModifier
   implements Operation<Integer>
{
   private int value;

   public static int with (CharacterActor character, AbilityScoreOption option) {
      int value = character.status().content().get(option).value();
      return new CalculateAbilityScoreModifier(value).process();
   }
   public static int with (AbilityScoreComposition composition, AbilityScoreOption option) {
      int value = composition.content().get(option).value();
      return new CalculateAbilityScoreModifier(value).process();
   }
   public static int with (AbilityScoreComponent abilityScore) {
      int value = abilityScore.value();
      return new CalculateAbilityScoreModifier(value).process();
   }
   public static int with (int value) {
      return new CalculateAbilityScoreModifier(value).process();
   }

   public Integer process () {
      return (int) Math.floor(value / 3) - 5;
   }
}
