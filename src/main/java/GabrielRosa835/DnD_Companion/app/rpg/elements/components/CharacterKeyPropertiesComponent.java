package app.rpg.elements.components;

import app.rpg.models.Component;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class CharacterKeyPropertiesComponent
	implements Component<CharacterKeyPropertiesComponent>
{
	private int attunementLimit = 3;
	private int proficiencyBonus = 2;

	@Override public void update (CharacterKeyPropertiesComponent clone) {
		this.attunementLimit = clone.attunementLimit;
		this.proficiencyBonus = clone.proficiencyBonus;
	}
}
