package experimental.fixtures;

import behaviors.*;
import elements.compositions.ResistanceComposition;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class TestEntity implements
      Effectable<TestEntity>
{
   private Object fieldObject;
   private String fieldString;
   private Integer fieldInteger;
   private TestComponent fieldComponent;

   private ResistanceComposition<TestEntity> resistances;

   @Override public void applyEffect (Effect<TestEntity> effect, ResistanceComposition<TestEntity> resistances) {
      var effectResult = resistances.applyAllTo(effect);
      var result = effectResult.applyTo(this);
      update(result);
   }
   protected void update (TestEntity clone) {
      this.fieldObject = clone.fieldObject;
      this.fieldString = clone.fieldString;
      this.fieldInteger = clone.fieldInteger;
      this.fieldComponent = clone.fieldComponent;
      this.resistances = clone.resistances;
   }
}
