package GabrielRosa835.dnd_companion.app.elements.entities.system;


import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Accessors(fluent = true)
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
	private Integer id;

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
}
