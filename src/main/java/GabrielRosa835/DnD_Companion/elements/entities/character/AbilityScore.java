package elements.entities.character;

import elements.entities.items.Armor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table (name = "ability_scores_types")

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
