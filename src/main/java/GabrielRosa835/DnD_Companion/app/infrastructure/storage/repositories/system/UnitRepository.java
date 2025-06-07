package app.infrastructure.storage.repositories.system;

import app.infrastructure.storage.mappings.options.system.*;
import org.springframework.data.jpa.repository.*;

public interface UnitRepository extends JpaRepository<UnitMapping, Short> {
}
