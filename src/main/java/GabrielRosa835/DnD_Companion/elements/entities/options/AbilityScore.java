package elements.entities.options;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PUBLIC, staticName = "create")
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Accessors (fluent = true)
@ToString
@Getter
public class AbilityScore
{
	private String name;

	public static int calculateModifier(int value) {
		return (int) Math.floor(value / 3) - 5;
	}
}
