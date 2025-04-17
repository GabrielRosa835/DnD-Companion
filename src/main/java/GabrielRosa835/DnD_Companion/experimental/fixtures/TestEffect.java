package experimental.fixtures;

import behaviors.IEffect;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@Accessors (fluent = true)
@Getter
@Builder (setterPrefix = "with")
public class TestEffect	extends IEffect<TestComponent>
{
   private Integer newInteger;

   @Override public void setup () {

   }
   @Override public void execute () {

   }
   @Override public TestComponent assemble () {
      return TestComponent.builder()
            .withFieldObject(target.fieldObject())
            .withFieldString(target.fieldString())
            .withFieldInteger(newInteger)
            .build();
   }
}