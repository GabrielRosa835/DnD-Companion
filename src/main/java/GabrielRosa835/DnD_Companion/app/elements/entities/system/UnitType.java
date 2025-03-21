package GabrielRosa835.dnd_companion.app.elements.entities.system;

import jakarta.persistence.*;
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
public class UnitType
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String name;
}
