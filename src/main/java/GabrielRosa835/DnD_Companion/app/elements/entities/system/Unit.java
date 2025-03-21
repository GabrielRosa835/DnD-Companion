package GabrielRosa835.dnd_companion.app.elements.entities.system;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
@Entity
public class Unit
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double normalizingFactor;

	private String singularForm;

	private String abbreviation;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private UnitType type;

	private String name;
}
