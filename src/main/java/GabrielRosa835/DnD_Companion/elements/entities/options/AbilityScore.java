package elements.entities.options;

import lombok.*;
import lombok.experimental.*;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class AbilityScore
{
	private String name;

	public static int calculateModifier(int value) {
		return (int) Math.floor(value / 3) - 5;
	}
}
