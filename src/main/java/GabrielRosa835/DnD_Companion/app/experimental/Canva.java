package app.experimental;

import app.infrastructure.storage.repositories.system.*;
import org.springframework.stereotype.*;

@Component
public class Canva {

	private final UnitRepository unitRepository;
	private final UnitTypeRepository unitTypeRepository;

	public Canva (UnitRepository unitRepository, UnitTypeRepository unitTypeRepository) {
		this.unitRepository = unitRepository;
		this.unitTypeRepository = unitTypeRepository;
	}

	public void run () {

	}
}
