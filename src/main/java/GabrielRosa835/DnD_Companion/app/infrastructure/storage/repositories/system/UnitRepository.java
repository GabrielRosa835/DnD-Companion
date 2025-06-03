package app.infrastructure.storage.repositories.system;

import app.domain.elements.options.system.*;
import org.springframework.data.jpa.repository.*;

public interface UnitRepository extends JpaRepository<Unit, Short> {
}
