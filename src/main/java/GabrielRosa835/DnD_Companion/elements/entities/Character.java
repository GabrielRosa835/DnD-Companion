package elements.entities;

import elements.compositions.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
@Accessors(fluent = true)
public class Character implements Entity
{
	private String name;

	private AbilityScoreComposition status;
	private SkillComposition skills;
	private EffectiveCharacterClassComposition classes;

	private int proficiencyBonus;
}
