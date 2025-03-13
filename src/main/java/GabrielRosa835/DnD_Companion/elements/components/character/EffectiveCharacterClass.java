package elements.components.character;

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
	private CharacterClass referencedClass;
	private CharacterClass.Type type;
	private int classLevel;

//	private List<Feature> features;
}