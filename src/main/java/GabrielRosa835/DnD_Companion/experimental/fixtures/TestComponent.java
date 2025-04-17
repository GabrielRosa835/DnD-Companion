package experimental.fixtures;

import behaviors.*;
import lombok.*;
import lombok.experimental.*;

import java.util.Set;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class TestComponent implements Effectable<TestComponent>
{
   private Object fieldObject;
   private String fieldString;
   private Integer fieldInteger;

   @Override
   public TestComponent applyEffect (Effect<TestComponent> effect, Set<Catalyst<?>> catalysts) {
      var result = effect.applyTo(this, catalysts);
      update(result);
      return this;
   }

   public void update(TestComponent clone) {
      this.fieldObject = clone.fieldObject;
      this.fieldString = clone.fieldString;
      this.fieldInteger = clone.fieldInteger;
   }
}