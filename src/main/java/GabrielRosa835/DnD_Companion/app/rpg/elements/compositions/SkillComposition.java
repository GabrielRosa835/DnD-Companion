package app.rpg.elements.compositions;

import app.rpg.elements.components.SkillComponent;
import app.rpg.elements.models.Composition;
import app.rpg.elements.options.SkillOption;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(staticName = "empty")
@Accessors(fluent = true)
@Builder(setterPrefix = "with")
@Getter
public class SkillComposition // "Skills"
		implements Composition<SkillComposition> {
	@Singular("skill")
	private Map<SkillOption, SkillComponent> content = new HashMap<>();

	@Override
	public void update(SkillComposition clone) {
		this.content.clear();
		this.content.putAll(clone.content);
	}
}
