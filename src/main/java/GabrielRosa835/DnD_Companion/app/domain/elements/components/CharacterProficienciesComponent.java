package app.domain.elements.components;

import app.domain.elements.entities.options.characterOptions.*;
import app.domain.elements.entities.options.items.*;
import app.infrastructure.storage.mappings.associations.*;
import jakarta.persistence.*;

import java.util.*;

@Embeddable
public record CharacterProficienciesComponent(
		@OneToMany (fetch = FetchType.LAZY)
		@MapKey (name = "category")
		Map<ArmorCategory, CharacterArmorProficienciesAssociation> armors,

		@OneToMany (fetch = FetchType.LAZY)
		@MapKey (name = "category")
		Map<WeaponCategory, CharacterWeaponProficienciesAssociation> weapons,

		@OneToMany (fetch = FetchType.LAZY)
		@MapKey (name = "skill")
		Map<Skill, CharacterSkillProficienciesAssociation> skills,

		@OneToMany (fetch = FetchType.LAZY)
		@MapKey (name = "language")
		Map<Language, CharacterLanguageProficienciesAssociation> languages,

		@OneToMany (fetch = FetchType.LAZY)
		@MapKey (name = "tool")
		Map<Tool, CharacterToolProficienciesAssociation> tools
) {}
