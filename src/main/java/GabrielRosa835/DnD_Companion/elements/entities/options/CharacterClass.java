package elements.entities.options;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class CharacterClass
{
	private String name;
}
