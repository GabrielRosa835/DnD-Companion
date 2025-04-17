package app.rpg.elements.components;

import app.rpg.models.Component;
import app.rpg.elements.options.CharacterClassOption;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterClassComponent
	implements Component<CharacterClassComponent>
{
	private CharacterClassOption type;
	private int level;

	@Override public void update (CharacterClassComponent clone) {
		this.level = clone.level;
		this.type = clone.type;
	}
}