package app.experimental;

import app.domain.elements.options.system.*;
import app.infrastructure.storage.repositories.system.*;
import org.springframework.stereotype.*;

@Component
public class Canva {

	private final UnitRepository unitRepo;
	private final UnitTypeRepository unitTypeRepo;

	public Canva (UnitRepository unitRepo, UnitTypeRepository unitTypeRepo) {
		this.unitRepo = unitRepo;
		this.unitTypeRepo = unitTypeRepo;
	}

	private UnitType type = UnitType.createNew("Length");
	private Unit unit = Unit.createNew("Meters", "m", "Meter", 1, type);

	public void run () {
		System.out.println(unitTypeRepo.save(type));
		System.out.println(unitRepo.save(unit));
	}
}
