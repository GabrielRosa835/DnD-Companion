package app.rpg.elements.compositions;

import app.rpg.elements.components.CharacterClassComponent;
import app.rpg.elements.models.Composition;
import app.rpg.elements.options.CharacterClassOption;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(staticName = "empty")
@Accessors(fluent = true)
@Builder(setterPrefix = "with")
@Getter
public class CharacterClassComposition // classes
		implements Composition<CharacterClassComposition> {
	@Singular("class")
	private Map<CharacterClassOption, CharacterClassComponent> content = new HashMap<>();

	@Override
	public void update(CharacterClassComposition clone) {
		this.content.clear();
		this.content.putAll(clone.content);
	}
}
