package app.rpg.elements.compositions;

import app.rpg.elements.components.AbilityScoreComponent;
import app.rpg.models.Composition;
import app.rpg.elements.options.AbilityScoreOption;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (staticName = "empty")
@Accessors (fluent = true)
@Builder (setterPrefix = "with")
@Getter
public class AbilityScoreComposition // "Status"
	implements Composition<AbilityScoreComposition>
{
	@Singular("abilityScore")
	private Map<AbilityScoreOption, AbilityScoreComponent> content = new HashMap<>();

	@Override public void update(AbilityScoreComposition clone) {
		this.content.clear();
		this.content.putAll(clone.content);
	}
}
