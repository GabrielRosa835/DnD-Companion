package elements.entities.system;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class DamageType
{
   private String name;
}
