package elements.entities.system;

import common.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.JpaRepository;
import tactics.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
@Entity
public class Measure implements
		Effect.Applicable<Measure>,
		Replicable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	@ManyToOne
	@JoinColumn(name = "unit_id", nullable = false)
	private Unit unit;

	private double value;

	@Override
	public Measure applyEffect(Effect<Measure> effect) {
		var result = effect.applyTo(this);
		this.value = result.value;
		this.unit = result.unit;
		return this;
	}

	public interface Repository extends JpaRepository<Measure, Integer> {}
}
