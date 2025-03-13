package elements.entities.options;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)

@Entity
public class CharacterClass
{
	private String name;
}
