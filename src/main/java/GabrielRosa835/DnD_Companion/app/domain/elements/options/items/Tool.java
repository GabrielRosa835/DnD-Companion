package app.domain.elements.options.items;

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
@Table (name = "opt_tools")
public class Tool implements DomainEntity, IsItem {

	@ManyToOne
	Item itemProperties;

	@Column (columnDefinition = "TEXT")
	String description;

	@Override public String name() {
		return itemProperties.name();
	}
}
