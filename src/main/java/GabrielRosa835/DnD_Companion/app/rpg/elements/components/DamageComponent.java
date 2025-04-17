package app.rpg.elements.components;

import app.rpg.models.Component;
import app.rpg.elements.options.DamageTypeOption;
import app.rpg.elements.options.DiceOption;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class DamageComponent
   implements Component<DamageComponent>
{
   private List<DiceOption> diceOptions;
   private DamageTypeOption type;
   private int modifier;

   @Override public void update (DamageComponent clone) {
      this.diceOptions.clear();
      this.diceOptions.addAll(clone.diceOptions);
      this.type = clone.type;
      this.modifier = clone.modifier;
   }
}
