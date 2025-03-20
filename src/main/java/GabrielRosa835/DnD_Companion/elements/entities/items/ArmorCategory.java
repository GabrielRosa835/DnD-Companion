package elements.entities.items;

import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor(staticName = "create")
@Accessors(fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class ArmorCategory
{
	private int id;
	private String name;

	public interface Repository extends JpaRepository<ArmorCategory, Integer> {}
}
