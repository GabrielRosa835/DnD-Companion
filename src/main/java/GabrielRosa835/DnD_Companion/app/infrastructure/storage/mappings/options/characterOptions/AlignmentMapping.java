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
@Table (name = "opt_alignments")
public class AlignmentMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (name = "order_type")
	String order;
	@Column (name = "moral_type")
	String moral;

	@Column (columnDefinition = "TEXT")
	String description;
}