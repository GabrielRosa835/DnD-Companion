package app.infrastructure.storage.mappings.options.characterOptions;

import app.infrastructure.storage.*;
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
@Table (name = "opt_skills")
public class SkillMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	AbilityScoreTypeMapping standardAbilityScore;
}