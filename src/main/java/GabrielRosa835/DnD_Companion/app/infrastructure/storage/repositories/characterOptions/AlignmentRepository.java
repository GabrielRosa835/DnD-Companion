package app.infrastructure.storage.repositories.characterOptions;

import app.infrastructure.storage.mappings.options.characterOptions.*;
import org.springframework.data.jpa.repository.*;

public interface AlignmentRepository extends JpaRepository<AlignmentMapping, Short> {
}
