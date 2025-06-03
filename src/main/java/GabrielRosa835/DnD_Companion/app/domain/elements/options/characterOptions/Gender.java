package app.domain.elements.options.characterOptions;

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
@Table (name = "opt_gender_types")
public class Gender implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}