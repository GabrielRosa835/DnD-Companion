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
@Table (name = "rel_player_character_speeds")
public class CharacterSpeedAssociation implements Persistent<Integer> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	PlayerCharacterMapping playerCharacterMapping;

	@ManyToOne (fetch = FetchType.LAZY)
	SpeedTypeMapping speedType;

	@ManyToOne (fetch = FetchType.LAZY)
	UnitMapping unit;
	float value;
}
