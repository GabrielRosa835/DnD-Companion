package GabrielRosa835.components;

import GabrielRosa835.models.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class EffectiveCharacterClass implements Composed
{
	private CharacterClass referencedClass;
	private CharacterClass.Type type;
	private int classLevel;

//	private List<Feature> features;
}