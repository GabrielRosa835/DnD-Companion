package GabrielRosa835.DnD_Companion;

import app.experimental.Canva;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DnDCompanionApplication {
	public static void main(String[] args) {

		Canva.use().test();

		// SpringApplication.run(app.DnDCompanionApplication.class, args);

	}
}
