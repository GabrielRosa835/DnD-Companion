package app.domain.elements.entities;

import app.domain.elements.options.characterOptions.*;
import app.domain.elements.variants.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (staticName = "create")
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Entity
@Table (name = "ent_players")
public class Player implements DomainEntity {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	PlayerRole role;
}
