package app.infrastructure.storage.mappings.associations;

import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.*;
import app.infrastructure.storage.mappings.options.characterOptions.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Setter
@Getter
@Entity
@Table (name = "rel_player_character_classes")
public class CharacterClassAssociation implements Persistent<Integer> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	PlayerCharacterMapping character;

	@ManyToOne (fetch = FetchType.LAZY)
	CharacterClassMapping characterClass;

	@ManyToOne (fetch = FetchType.LAZY)
	CharacterSubclassMapping subclass;

	short level;
}
