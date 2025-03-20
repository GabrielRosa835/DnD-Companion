package elements.components;

import elements.entities.system.DamageType;
import fundamentals.Dice;
import lombok.*;
import lombok.experimental.Accessors;
import tactics.Effect;

import java.util.List;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class DamageGroup implements
      Effect.Applicable<DamageGroup>
{
   private List<Dice> dices;
   private DamageType type;
   private int modifier;

   public DamageGroup applyEffect(Effect<DamageGroup> effect) {
      var result = effect.applyTo(this);
      this.modifier = result.modifier;
      this.dices = result.dices;
      this.type = result.type;
      return this;
   }
}
