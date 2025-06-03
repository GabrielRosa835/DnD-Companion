package app;

import app.experimental.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;

@SpringBootApplication
public class DnDCompanionApplication {

	public static void main (String[] args) {

		ApplicationContext context = SpringApplication.run(DnDCompanionApplication.class, args);
		var canva = context.getBean(Canva.class);
		canva.run();

	}
}