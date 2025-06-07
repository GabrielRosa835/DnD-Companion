package app.infrastructure.storage.mappings.associations;

import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.*;
import app.infrastructure.storage.mappings.options.system.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Getter
@Setter
@Entity
@Table (name = "rel_player_character_ability_score")
public class CharacterAbilityScoreAssociation implements Persistent<Integer> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	PlayerCharacterMapping playerCharacterMapping;

	@ManyToOne (fetch = FetchType.LAZY)
	ProficiencyTypeMapping savingThrowProficiency;

	@ManyToOne (fetch = FetchType.LAZY)
	AbilityScoreTypeMapping abilityScoreType;

	short value;
}
