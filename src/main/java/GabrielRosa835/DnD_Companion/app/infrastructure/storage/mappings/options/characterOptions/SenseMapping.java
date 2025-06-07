package app.infrastructure.storage.mappings.options.characterOptions;

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
@Table (name = "opt_senses")
public class SenseMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;
}

