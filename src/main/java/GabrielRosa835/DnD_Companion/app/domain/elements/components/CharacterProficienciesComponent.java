package app.domain.elements.components;

import app.domain.elements.options.characterOptions.*;
import app.domain.elements.options.items.*;
import app.domain.elements.options.system.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Embeddable
@With
public record CharacterProficienciesComponent(
		@MapKeyClass(Skill.class)
		@ManyToMany (fetch = FetchType.LAZY)
		Map<Skill, ProficiencyType> skills,

		@MapKeyClass (Tool.class)
		@ManyToMany (fetch = FetchType.LAZY)
		Map<Tool, ProficiencyType> tools,

		@MapKeyClass(Language.class)
		@ManyToMany (fetch = FetchType.LAZY)
		Map<Language, ProficiencyType> languages,

		@MapKeyClass(WeaponCategory.class)
		@ManyToMany (fetch = FetchType.LAZY)
		Map<WeaponCategory, ProficiencyType> weapons,

		@MapKeyClass(SpeedType.class)
		@ManyToMany (fetch = FetchType.LAZY)
		Map<ArmorCategory, ProficiencyType> armors
) {}
