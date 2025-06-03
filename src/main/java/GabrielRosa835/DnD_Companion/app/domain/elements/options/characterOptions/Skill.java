package app.domain.elements.options.characterOptions;

import app.domain.elements.options.system.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (staticName = "create")
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Entity
@Table (name = "opt_skills")
public class Skill implements DomainOption {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	AbilityScoreType standardAbilityScore;
}