package elements.entities.options;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class Skill
{
	private String name;
	private AbilityScore standardAbilityScore;
}
