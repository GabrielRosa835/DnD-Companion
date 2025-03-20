package elements.entities.system;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor (staticName = "create")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Accessors (fluent = true)
@ToString
@Getter
@Entity
public class UnitType
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id = null;

   @NotNull
   private String name;

   public interface Repository extends JpaRepository<UnitType, Integer> {}
}
