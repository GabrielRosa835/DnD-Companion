package GabrielRosa835.dnd_companion.app.elements.components;


import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
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
