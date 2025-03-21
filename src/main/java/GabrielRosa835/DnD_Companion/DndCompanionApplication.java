package GabrielRosa835.dnd_companion;

import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class DndCompanionApplication implements CommandLineRunner
{
	@Autowired private UnitTypeRepository unitTypeRepository;
	@Autowired private UnitRepository unitRepository;
	@Autowired private MeasureRepository measureRepository;

	@Override public void run(String... args) throws Exception {
		new Main(unitTypeRepository, unitRepository, measureRepository).test();
	}

	public static void main(String[] args) {
		SpringApplication.run(DndCompanionApplication.class, args);
	}
}
