package elements.entities.system;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.JpaRepository;

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
	@Builder.Default
	private Integer id = null;

	private double normalizingFactor;

	private String singularForm;

	private String abbreviation;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private UnitType type;

	private String name;

	public interface Repository extends JpaRepository<Unit, Integer> {}
}
