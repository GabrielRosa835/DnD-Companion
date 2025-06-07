package app.infrastructure.storage.mappings.associations;

import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.*;
import app.infrastructure.storage.mappings.options.characterOptions.*;
import app.infrastructure.storage.mappings.options.system.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@Accessors (fluent = true)
@ToString
@Getter
@Setter
@Entity
@Table (name = "rel_player_character_skill_proficiencies")
public class CharacterSkillProficienciesAssociation implements Persistent<Integer> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	PlayerCharacterMapping character;

	@ManyToOne (fetch = FetchType.LAZY)
	SkillMapping skill;

	@ManyToOne (fetch = FetchType.LAZY)
	ProficiencyTypeMapping proficiency;
}
