package elements.entities.character;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterClass
{
	private String name;
}
