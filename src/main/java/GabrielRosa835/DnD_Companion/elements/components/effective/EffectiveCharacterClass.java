package elements.components.effective;

import elements.entities.options.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class EffectiveCharacterClass
{
	private CharacterClass type;
	private int classLevel;
}