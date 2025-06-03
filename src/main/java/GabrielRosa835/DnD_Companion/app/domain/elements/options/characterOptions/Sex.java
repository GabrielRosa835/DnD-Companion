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
@ToString
@Getter
@Entity
@Table (name = "opt_sexes")
public class Sex implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}

