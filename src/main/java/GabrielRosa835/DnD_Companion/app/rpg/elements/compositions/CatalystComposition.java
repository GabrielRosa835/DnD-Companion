package app.rpg.elements.compositions;

import app.strategies.Catalyst;
import app.rpg.models.Composition;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (staticName = "empty")
@Accessors (fluent = true)
@Builder (setterPrefix = "with")
@Getter
public class CatalystComposition // "Resistances"
   implements Composition<CatalystComposition>
{
   @Singular("catalyst")
   private Set<Catalyst> content = new HashSet<>();

   @Override public void update(CatalystComposition clone) {
      this.content.clear();
      this.content.addAll(clone.content);
   }
}
