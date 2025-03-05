package GabrielRosa835.entities;

import GabrielRosa835.annotations.*;
import GabrielRosa835.compositions.*;
import GabrielRosa835.models.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
@Accessors(fluent = true)

@AutoEffectable
public class Character implements Entity
{
	private String name;

	private AbilityScoreComposition status;
	private SkillComposition skills;
	private EffectiveCharacterClassComposition classes;

	private int proficiencyBonus;
}
