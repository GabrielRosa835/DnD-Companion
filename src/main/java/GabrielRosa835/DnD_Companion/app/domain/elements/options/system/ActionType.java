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
@Entity
@Table (name = "opt_action_types")
public class ActionType implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}