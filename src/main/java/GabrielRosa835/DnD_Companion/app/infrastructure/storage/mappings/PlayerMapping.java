package app.infrastructure.storage.mappings;

import app.infrastructure.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter
@Entity
@Table (name = "ent_players")
public class PlayerMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	PlayerRoleMapping role;
}
