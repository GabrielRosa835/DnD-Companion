package elements.entities.options;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "create")
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class ArmorCategory
{
	String name;
}
