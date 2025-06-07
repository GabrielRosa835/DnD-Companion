package app.infrastructure.storage.mappings.options.system;

import app.infrastructure.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Getter
@Setter
@Entity
@Table (name = "opt_speed_types")
public class SpeedTypeMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}
