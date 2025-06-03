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
@Builder (setterPrefix = "with")
@Getter
@Entity
@Table (name = "opt_ability_score_types")
public class AbilityScoreType implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}
