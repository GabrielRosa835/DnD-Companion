package app;

import org.springframework.boot.autoconfigure.*;
import app.experimental.Canva;

@SpringBootApplication
public class DnDCompanionApplication {
	public static void main(String[] args) {

		Canva.use().test();

		// SpringApplication.run(DnDCompanionApplication.class, args);

	}
}