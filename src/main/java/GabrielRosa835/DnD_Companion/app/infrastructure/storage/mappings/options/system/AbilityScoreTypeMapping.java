package app.infrastructure.storage.mappings.options.system;

import app.infrastructure.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter
@Entity
@Table (name = "opt_ability_score_types")
public class AbilityScoreTypeMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}
