package GabrielRosa835.dnd_companion.app.elements.entities.items;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PUBLIC, staticName = "create")
@Accessors (fluent = true)
@ToString
@Getter
public class ItemTag
{
	private String name;
}
