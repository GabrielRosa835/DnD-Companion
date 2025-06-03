package app.domain.elements.options.system;

import app.domain.elements.variants.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (staticName = "create")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter (AccessLevel.PRIVATE)
@Entity
@Table (name = "opt_proficiency_types")
public class ProficiencyType implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	double multiplier;
}
