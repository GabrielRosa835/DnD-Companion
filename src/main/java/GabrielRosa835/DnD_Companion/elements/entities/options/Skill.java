package elements.entities.options;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PUBLIC, staticName = "create")
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Accessors (fluent = true)
@ToString
@Getter
public class Skill
{
	private AbilityScore standardAbilityScore;
	private String name;
}
