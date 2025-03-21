package GabrielRosa835.dnd_companion.app.elements.entities.character;

import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.*;

@AllArgsConstructor (staticName = "create")
@Accessors (fluent = true)
@ToString
@Getter
public class AbilityScore
{
	private int id;
	private String name;

	public interface Repository extends JpaRepository<AbilityScore, Integer> {}
}
