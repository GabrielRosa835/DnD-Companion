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
@Entity
@Table (name = "opt_alingments")
public class Alignment implements DomainEntity {

	@Id
	@Column (name = "name")
	@Override public String name () {
		return order + " " + moral;
	}

	@Column (columnDefinition = "TEXT")
	String description;

	String order;
	String moral;
}